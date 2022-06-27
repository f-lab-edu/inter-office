
CREATE TABLE `users` (
                         `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `email` varchar(50) NOT NULL,
                         `password` varchar(200) NOT NULL,
                         `username` varchar(50) NOT NULL,
                         `phoneNumber` varchar(50) NOT NULL,
                         `createdAt` datetime DEFAULT null,
                         `modifiedAt` datetime DEFAULT null
) ENGINE=InnoDB DEFAULT CHARSET='utf8'