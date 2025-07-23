-- Create orders table
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_amount NUMERIC(15,2) NOT NULL,
    discount NUMERIC(15,2) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

-- Create order_cart_items table for storing cart items
CREATE TABLE order_cart_items (
    order_id BIGINT NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
    cart_item VARCHAR(255) NOT NULL
);
