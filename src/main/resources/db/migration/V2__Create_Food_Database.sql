create table if not exists assortment.food
(
    id          serial primary key,
    name        varchar,
    category_id int,
    description varchar,
    created_on  timestamp with time zone,
    update_on   timestamp with time zone
)