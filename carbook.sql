CREATE DATABASE IF NOT EXISTS `carbook`;
USE carbook;

-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Мар 03 2023 г., 14:24
-- Версия сервера: 8.0.24
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `carbook`
--

-- --------------------------------------------------------

--
-- Структура таблицы `auto`
--

CREATE TABLE `auto` (
  `id` bigint NOT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price_per_day` double DEFAULT NULL,
  `consumption_per_100` double DEFAULT NULL,
  `reserve` int NOT NULL,
  `power` int NOT NULL,
  `engine` double DEFAULT NULL,
  `body_type` varchar(255) DEFAULT NULL,
  `transmission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fuel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `capacity` int NOT NULL,
  `number` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `places` int NOT NULL,
  `state` tinyint(1) NOT NULL,
  `photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `auto`
--

INSERT INTO `auto` (`id`, `brand`, `model`, `price_per_day`, `consumption_per_100`, `reserve`, `power`, `engine`, `body_type`, `transmission`, `fuel`, `color`, `capacity`, `number`, `places`, `state`, `photo`) VALUES
(110, 'Audi', 'RS6', 129.35, 11.7, 624, 600, 4, 'Универсал', 'АКПП', 'Бензин', 'Серый', 631, '1336OB7', 5, 1, 'Audi_1336OB7'),
(126, 'Nissan', 'Juke', 58.25, 4.9, 765, 117, 1, 'Внедорожник', 'МКПП', 'Бензин', 'Красный', 422, '2331AT7', 5, 1, 'Nissan_2331AT7'),
(127, 'BMW', 'M5F90', 121.27, 10.5, 452, 600, 4.4, 'Седан', 'АКПП', 'Бензин', 'Красный', 380, '6542AA7', 5, 0, 'BMW_6542AA7'),
(129, 'Audi', 'A5', 102.63, 5.9, 593, 249, 2, 'Купе', 'АКПП', 'Бензин', 'Зелёный', 298, '1875MO7', 5, 1, 'Audi_1875MO7'),
(131, 'Ford', 'Focus', 90.2, 4.8, 575, 125, 1, 'Хэтчбек', 'МКПП', 'Бензин', 'Оранжевый', 375, '8125HB7', 5, 1, 'Ford_8125HB7'),
(132, 'Volvo', 'S60', 112.55, 5.8, 683, 152, 1.5, 'Седан', 'АКПП', 'Бензин', 'Серый', 380, '7312AA7', 5, 1, 'Volvo_7312AA7'),
(133, 'Volkswagen', 'Polo', 78.66, 6.4, 547, 90, 1.6, 'Лифтбек', 'МКПП', 'Бензин', 'Серый', 530, '1399OB7', 5, 0, 'Volkswagen_1399OB7'),
(134, 'LADA', 'Vesta', 65.42, 6.9, 510, 106, 1.6, 'Седан', 'МКПП', 'Бензин', 'Зелёный', 480, '3310OO7', 5, 1, 'LADA_3310OO7'),
(136, 'Volvo', 'V60', 102.95, 5.9, 620, 122, 1.5, 'Универсал', 'АКПП', 'Бензин', 'Серый', 430, '5512BM7', 5, 1, 'Volvo_5512BM7'),
(137, 'Skoda', 'Rapid', 78.42, 6, 529, 90, 1.6, 'Лифтбек', 'МКПП', 'Бензин', 'Синий', 530, '7221KO7', 5, 1, 'Skoda_7221KO7'),
(139, 'Volvo', 'XC90', 140.5, 7.9, 490, 249, 2, 'Внедорожник', 'АКПП', 'Бензин', 'Белый', 721, '3344BO7', 7, 1, 'Volvo_3344BO7');

-- --------------------------------------------------------

--
-- Структура таблицы `client`
--

CREATE TABLE `client` (
  `id` bigint NOT NULL,
  `id_user_id` bigint DEFAULT NULL,
  `second_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `patronymic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pass_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `driver_license` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `experience` int NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `client`
--

INSERT INTO `client` (`id`, `id_user_id`, `second_name`, `first_name`, `patronymic`, `series`, `pass_number`, `driver_license`, `experience`, `email`, `phone`, `address`) VALUES
(106, 105, 'Ковгунов', 'Никита', 'Игоревич', 'MP', '4613217', '26497946', 3, 'nikitos@gmail.com', '375295172367', 'ул. 1 Мая, д.72, кв. 18'),
(145, 144, 'Вакуленко', 'Дмитрий', 'Игоревич', 'HB', '5434263', '46765708', 3, 'dima@gmail.com', '375336686675', ''),
(147, 146, 'Московский', 'Олег', 'Игоревич', 'BM', '3546447', '23333333', 5, 'oleja@gmail.com', '333333333', ''),
(149, 148, 'Орлов', 'Иван', NULL, NULL, NULL, NULL, 0, 'ivan@yandex.by', NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `confirm`
--

CREATE TABLE `confirm` (
  `id` bigint NOT NULL,
  `id_auto_id` bigint DEFAULT NULL,
  `id_client_id` bigint DEFAULT NULL,
  `second_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `patronymic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pass_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `driver_license` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `experience` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `confirm`
--

INSERT INTO `confirm` (`id`, `id_auto_id`, `id_client_id`, `second_name`, `first_name`, `patronymic`, `series`, `pass_number`, `driver_license`, `brand`, `model`, `number`, `email`, `phone`, `experience`) VALUES
(160, 126, 106, 'Ковгунов', 'Никита', 'Игоревич', 'MP', '4613217', '26497946', 'Nissan', 'Juke', '2331AT7', 'nikitos@gmail.com', '335431657', 4),
(162, 133, 145, 'Вакуленко', 'Дмитрий', 'Игоревич', 'HB', '5434263', '46765708', 'Volkswagen', 'Polo', '1399OB7', 'dima@gmail.com', '375336686675', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(163);

-- --------------------------------------------------------

--
-- Структура таблицы `road_accident`
--

CREATE TABLE `road_accident` (
  `id` bigint NOT NULL,
  `date_road_accident` date DEFAULT NULL,
  `defect` varchar(255) DEFAULT NULL,
  `id_auto_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `road_accident`
--

INSERT INTO `road_accident` (`id`, `date_road_accident`, `defect`, `id_auto_id`) VALUES
(159, '2021-12-16', 'hghg', 127);

-- --------------------------------------------------------

--
-- Структура таблицы `service`
--

CREATE TABLE `service` (
  `id` bigint NOT NULL,
  `date_of_end` date DEFAULT NULL,
  `date_of_start` date DEFAULT NULL,
  `id_auto_id` bigint DEFAULT NULL,
  `id_road_accident_id` bigint DEFAULT NULL,
  `repair_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `active` tinyint NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `second_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `active`, `username`, `password`, `email`, `first_name`, `second_name`) VALUES
(1, 1, 'admin', '1', NULL, NULL, NULL),
(69, 1, 'Ivanov_Staff', '1ddddddd', 'ivanov@citycar.com', 'Иван', 'Иванов'),
(105, 1, 'Nikita', '1qqqqqqq', 'nikitos@gmail.com', 'Никита', 'Ковгунов'),
(140, 1, 'Kushnerov_Staff', '1qqqqqqq', 'kushnerov@citycar.com', 'Максим', 'Кушнеров'),
(141, 1, 'Volchek_Staff', '1qqqqqqq', 'volchek@citycar.com', 'Герман', 'Волчёк'),
(142, 1, 'Demchenko_Staff', '1qqqqqqq', 'demchenko@citycar.com', 'Всеволод', 'Демченко'),
(143, 1, 'Savchenko_Staff', '1qqqqqqq', 'savchenko@citycar.com', 'Артём', 'Савченко'),
(144, 1, 'DimDim', '1qqqqqqq', 'dima@gmail.com', 'Дмитрий', 'Вакуленко'),
(146, 1, 'Olivejik', '1qqqqqqq', 'oleja@gmail.com', 'Олег', 'Московский'),
(148, 1, 'ivano', '1qqqqqqq', 'ivan@yandex.by', 'Иван', 'Орлов'),
(161, 1, 'SFASF_Staff', '1qqqqqqq', 'dsfdsf@citycar.com', 'Никита', 'Сидоров');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'ADMIN'),
(105, 'USER'),
(140, 'STAFF'),
(141, 'STAFF'),
(142, 'STAFF'),
(143, 'STAFF'),
(144, 'USER'),
(146, 'USER'),
(148, 'USER'),
(69, 'STAFF'),
(161, 'STAFF');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `auto`
--
ALTER TABLE `auto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `number` (`number`);

--
-- Индексы таблицы `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user_id` (`id_user_id`);

--
-- Индексы таблицы `confirm`
--
ALTER TABLE `confirm`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_auto_id` (`id_auto_id`),
  ADD KEY `id_client_id` (`id_client_id`);

--
-- Индексы таблицы `road_accident`
--
ALTER TABLE `road_accident`
  ADD PRIMARY KEY (`id`),
  ADD KEY `road_accident_ibfk_1` (`id_auto_id`);

--
-- Индексы таблицы `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id`),
  ADD KEY `date_of_end` (`date_of_end`,`date_of_start`),
  ADD KEY `service_ibfk_1` (`id_auto_id`),
  ADD KEY `service_ibfk_2` (`id_road_accident_id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`id_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `confirm`
--
ALTER TABLE `confirm`
  ADD CONSTRAINT `confirm_ibfk_1` FOREIGN KEY (`id_auto_id`) REFERENCES `auto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `confirm_ibfk_2` FOREIGN KEY (`id_client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `road_accident`
--
ALTER TABLE `road_accident`
  ADD CONSTRAINT `road_accident_ibfk_1` FOREIGN KEY (`id_auto_id`) REFERENCES `auto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `service_ibfk_1` FOREIGN KEY (`id_auto_id`) REFERENCES `auto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `service_ibfk_2` FOREIGN KEY (`id_road_accident_id`) REFERENCES `road_accident` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
