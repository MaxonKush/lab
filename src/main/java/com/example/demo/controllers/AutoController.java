package com.example.demo.controllers;

import com.example.demo.models.Auto;
import com.example.demo.models.Confirm;
import com.example.demo.models.RoadAccident;
import com.example.demo.models.Service;
import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.ConfirmRepository;
import com.example.demo.repository.RoadAccidentRepository;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/auto")
@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('STAFF')")
public class AutoController {

    @Autowired
    AutoRepository autoRepository;
    @Autowired
    RoadAccidentRepository roadAccidentRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ConfirmRepository confirmRepository;

    @GetMapping("/auto")
    public String autoList(Model model){
        model.addAttribute("autos", autoRepository.findAll());
        model.addAttribute("roadAccident", roadAccidentRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        return "autoList";
    }

    @GetMapping("/auto/add")
    public String autoAdd(Model model){
        return "autoAdd";
    }

    @PostMapping("/auto/add")
    public String autoPostAdd(@RequestParam String brand,
                              @RequestParam String model,
                              @RequestParam String body_type,
                              @RequestParam String color,
                              @RequestParam String transmission,
                              @RequestParam String fuel,
                              @RequestParam String photo,
                              @RequestParam String number,
                              @RequestParam Double engine,
                              @RequestParam Double consumption_per_100,
                              @RequestParam Double price_per_day,
                              @RequestParam int places,
                              @RequestParam int reserve,
                              @RequestParam int power,
                              @RequestParam int capacity,
                              @RequestParam int state, Model models){
        Auto auto = new Auto(brand, model, body_type, color, transmission, fuel, photo,
                number, engine, consumption_per_100, price_per_day, places, reserve, power, capacity, state);

        Auto autoCheckNumber = autoRepository.findByNumber(auto.getNumber());

        if(autoCheckNumber != null){
            models.addAttribute("errorNumber", "Авто с таким номером уже существует!");
            return "autoAdd";
        }

        auto.setPhoto(brand+"_"+number);
        autoRepository.save(auto);

        return "redirect:/auto";
    }

    @GetMapping("/auto/{id}")
    public String autoSingle(@PathVariable(value = "id") long id, Model models){
        if(!autoRepository.existsById(id)){
            return "redirect:/";
        }

        Optional<Auto> auto = autoRepository.findById(id);
        ArrayList<Auto> res = new ArrayList<>();
        auto.ifPresent(res::add);
        models.addAttribute("auto", res);
        return "autosingle";
    }

    @PostMapping("/auto/{id}")
    public String autoSave(@PathVariable(value = "id") long id,
                           @RequestParam String brand,
                           @RequestParam String model,
                           @RequestParam String body_type,
                           @RequestParam String color,
                           @RequestParam String transmission,
                           @RequestParam String fuel,
                           @RequestParam String photo,
                           @RequestParam String number,
                           @RequestParam Double engine,
                           @RequestParam Double consumption_per_100,
                           @RequestParam Double price_per_day,
                           @RequestParam int places,
                           @RequestParam int reserve,
                           @RequestParam int power,
                           @RequestParam int capacity,
                           @RequestParam int state, Model models){

        Auto auto = autoRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));
        auto.setBrand(brand);
        auto.setModel(model);
        auto.setBody_type(body_type);
        auto.setColor(color);
        auto.setTransmission(transmission);
        auto.setFuel(fuel);
        auto.setPhoto(photo);
        auto.setNumber(number);
        auto.setEngine(engine);
        auto.setConsumption_per_100(consumption_per_100);
        auto.setPrice_per_day(price_per_day);
        auto.setPlaces(places);
        auto.setReserve(reserve);
        auto.setPower(power);
        auto.setCapacity(capacity);
        auto.setState(state);
        autoRepository.save(auto);
        return "redirect:/auto";
    }

    @PostMapping("/auto/{id}/remove")
    public String autoDelete(@PathVariable(value = "id") long id, Model models){
        Auto auto = autoRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));

        autoRepository.delete(auto);
        return "redirect:/auto";
    }

    //------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/auto/road_accident/{id}")
    public String road_accidentAdd(@PathVariable(value = "id") long id, Model model){

        Optional<Auto> auto = autoRepository.findById(id);
        ArrayList<Auto> res = new ArrayList<>();
        auto.ifPresent(res::add);

        model.addAttribute("road_accident", roadAccidentRepository.findAll());
        model.addAttribute("auto", res);

        return "road_accident";
    }

    @PostMapping("/auto/road_accident/{id}")
    public String road_accidentPostAdd(@PathVariable(value = "id") long id, @RequestParam Long id_auto_id,
                                       @RequestParam String date_road_accident,
                                       @RequestParam String defect, Model model){

        RoadAccident roadAccident = new RoadAccident(id_auto_id, date_road_accident, defect);


        Auto autos = autoRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));
        autos.setState(0);

        roadAccidentRepository.save(roadAccident);

        return "redirect:/auto";
    }

    @GetMapping("/auto/road_accident/list")
    public String road_accidentList(Model model){
        model.addAttribute("road_accident", roadAccidentRepository.findAll());
        return "road_accidentList";
    }

    @PostMapping("/auto/road_accident/list")
    public String road_accidentPostList(@RequestParam Long id_auto_id,
                                       @RequestParam String date_road_accident,
                                       @RequestParam String defect, Model model){

        RoadAccident roadAccident = new RoadAccident(id_auto_id, date_road_accident, defect);

        roadAccidentRepository.save(roadAccident);

        return "redirect:/auto";
    }

    //------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------------------------------------------------------------//
    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/auto/service/{id}")
    public String serviceAdd(@PathVariable(value = "id") long id, Model model){

        Optional<Auto> auto = autoRepository.findById(id);
        ArrayList<Auto> res = new ArrayList<>();
        auto.ifPresent(res::add);

        model.addAttribute("road_accident", roadAccidentRepository.findAll());
        model.addAttribute("autos", autoRepository.findAll());
        model.addAttribute("auto", res);

        return "service";
    }

    /*@PostMapping("/auto/service/{id}")
    public String servicePostAdd(@PathVariable(value = "id") long id, @RequestParam Long id_auto_id,
                                 @RequestParam Long id_road_accident_id,
                                 @RequestParam String date_of_start,
                                 @RequestParam String date_of_end,
                                 @RequestParam String repair_description, Model model){*/
    @PostMapping("/auto/service/{id}")
    public String servicePostAdd(@PathVariable(value = "id") long id, @RequestParam Long id_auto_id,
                                 @RequestParam Long id_road_accident_id, Model model){

        //Service service = new Service(id_auto_id, id_road_accident_id, date_of_start, date_of_end, repair_description);
        Service service = new Service(id_auto_id, id_road_accident_id);


        Auto autos = autoRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));
        autos.setState(0);

        serviceRepository.save(service);

        return "redirect:/auto/service/list";
    }


    @GetMapping("/auto/service/list")
    public String serviceList(Model model){
        model.addAttribute("service", serviceRepository.findAll());
        return "serviceList";
    }

    @PostMapping("/auto/service/list")
    public String servicePostList(@RequestParam Long id_auto_id, @RequestParam Long id_road_accident_id,
                                        @RequestParam String date_of_start, @RequestParam String date_of_end,
                                        @RequestParam String repair_description, Model model){

        Service service = new Service(id_auto_id, id_road_accident_id, date_of_start, date_of_end, repair_description);

        serviceRepository.save(service);

        return "redirect:/auto";
    }




    @GetMapping("/auto/service/edit/{id}")
    public String serviceSingle(@PathVariable(value = "id") long id, Model models){
        if(!serviceRepository.existsById(id)){
            return "redirect:/";
        }

        Optional<Service> service = serviceRepository.findById(id);
        ArrayList<Service> res = new ArrayList<>();
        service.ifPresent(res::add);
        models.addAttribute("service", res);

        models.addAttribute("auto", autoRepository.findAll());
        models.addAttribute("ra", roadAccidentRepository.findAll());
        /*Optional<Auto> auto = autoRepository.findById(id);
        ArrayList<Auto> result = new ArrayList<>();
        auto.ifPresent(result::add);
        models.addAttribute("auto", result);*/

        return "serviceEdit";
    }

    @PostMapping("/auto/service/edit/{id}")
    public String serviceSave(@PathVariable(value = "id") long id,
                              @RequestParam long id_auto_id,
                              @RequestParam String date_of_start,
                              @RequestParam String date_of_end,
                              @RequestParam String repair_description, Model model){

        Service service = serviceRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Service not found"));
        service.setId_auto_id(id_auto_id);
        service.setDate_of_start(date_of_start);


        Auto autos = autoRepository.findById(id_auto_id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));

        if (date_of_end.isEmpty()) {
            service.setDate_of_end(null);
        }
        else {
            service.setDate_of_end(date_of_end);
            autos.setState(1);
        }

        if(repair_description.isEmpty()){
            service.setRepair_description(null);
        }
        else {
            service.setRepair_description(repair_description);
        }

        serviceRepository.save(service);
        return "redirect:/auto/service/list";
    }

    @GetMapping("/auto/confirm/list")
    public String confirmList(Model model){

        model.addAttribute("confirm", confirmRepository.findAll());
        model.addAttribute("autos", autoRepository.findAll());

        return "confirmList";
    }

    @PostMapping("/auto/confirm/{id}/remove")
    public String confirmDelete(@PathVariable(value = "id") long id,
                                @RequestParam long id_auto_id,
                                Model models){

        Auto autos = autoRepository.findById(id_auto_id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));
        autos.setState(1);

        Confirm confirms = confirmRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Auto not found"));

        autoRepository.save(autos);
        confirmRepository.delete(confirms);
        return "redirect:/auto";
    }
}
