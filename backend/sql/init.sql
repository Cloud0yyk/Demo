-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
            `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
            `username` VARCHAR(50) NOT NULL UNIQUE,
            `password` VARCHAR(100) NOT NULL,
            `is_admin` BOOLEAN DEFAULT FALSE
);

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `is_admin`) VALUES
             (1931731271654940674, 'yyk', 'd169a0fe209e7e48c1aa4238690e25b9', 0), -- yyk&123456
             (1931732995702628353, 'cloud', 'd169a0fe209e7e48c1aa4238690e25b9', 0), -- cloud@123456
             (1931733227316289538, 'admin', 'd169a0fe209e7e48c1aa4238690e25b9', 1); -- admin@123456


-- 商品表
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
            `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
            `name` VARCHAR(100) NOT NULL,
            `price` DECIMAL(10,2) NOT NULL,             -- 原始价格
            `discount_price` DECIMAL(10,2) NOT NULL,    -- 秒杀价
            `stock` INT NOT NULL,                       -- 库存数量
            `create_time` DATE NOT NULL,
            `start_time` DATE NOT NULL,
            `end_time` DATE NOT NULL
);

-- 订单表
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
            `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
            `user_id` BIGINT NOT NULL,
            `goods_id` BIGINT NOT NULL,
            `create_time` DATE NOT NULL,
            FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
            FOREIGN KEY (`goods_id`) REFERENCES `goods`(`id`)
);
