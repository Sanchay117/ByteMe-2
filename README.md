# Byte Me! Food Ordering System

## Overview
"Byte Me!" is a command-line interface (CLI) application for managing food orders at the college canteen. It provides two main user roles:
- **Admin**: Manages the menu, updates food items, generates reports, and views orders.
- **Customer**: Places food orders, views available items, leave reviews, and checks order status.

This project uses the Java Collections Framework extensively to handle and manage lists of items, orders, and users efficiently.

## Features

### Admin Features
- **Add/Remove/Update Food Items**: Admins can add new food items to the menu or remove or update existing items.
- **View Pending Orders**: Admins can view all orders placed by customers that are just received or pending.
- **Update Order Status**: Admins can update the status of any order.
- **Process refunds**: Admins can select any order and refund it.
- **Handle Special Requests**: Admins can view and handle special requests made by customers on orders that have been just received or are pending.
- **Generate Report**: Admins can also generate reports of sales,numbers of orders and of popular items.

### Customer Features
- **Browse Menu**: Customers can view the available food items with details,search names or categories and even sort according to price.
- **Cart**: Customers can add multiple items to their cart, specifying the quantity for each. They can also adjust the quantity of items in their cart before checking out and even remove items and also they can view their total.
- **Place Orders**: Customers can place orders for items in the menu by checking out their cart.
- **Orders** : Customers can check their order history , cancel a order and even reorder previous orders.
- **View Order Status**: Customers can check the status of their orders.
- **Reviews**: Customers can leave a review on an item they've ordered and even see the reviews other customers have left.

## Java Collections Usage
The Collections Framework in Java is utilized across various classes to store and manage data efficiently:
- **ArrayList**: Used to store lists of food items, orders, and users. ArrayLists provide dynamic resizing and fast access for the application's needs.
- **HashMap**: Used to map items in an order with their quantity.

## Improvements Upon Previous Assignment

### GUI
A GUI can be launched separately from the CLI Main.java by launching GUI.java
- It has 2 screens
- One for showing food items on the Menu
- And the other for showing all orders
- Built Using Swing and AWT.
- No Real Time Communication between CLI and GUI to refresh, GUI has to be relaunched

### I/O Stream Management
All orders are saved in orders.txt and users in users.txt which are then loaded in an ArrayList when Main.java is launched.

### JUnit Testing
Run TestRunner.java for running InvalidLogin And OutOfStockOrder Tests.

## Getting Started

### Prerequisites
- **Java 8** or higher
- **Junit4 Framework**

### Running the Application
1. Clone the Repo and open it inside IntelliJ
2. Running The Command Line Interface [CLI]:
   In IntelliJ run Main.java
3. Running The Graphical User Interface [GUI]: In IntelliJ run GUI.java
4. Running JUnit Tests : In IntelliJ run TestRunner.java
5. **Note:** All these files are inside the src folder
