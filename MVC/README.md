# MVC Architecture



## 1. Relevant components

- [Thymeleaf](https://www.thymeleaf.org/)
- [H2 Database](http://h2database.com/html/main.html)

### 2. My understanding：

MVC is mainly divided into three parts: Model, View, and Controller.

In my code, the Model corresponds to the data structures and business logic found in the `model` folder, such as `product`, `item`, and `cart`. The View is represented by `index.html`, which is primarily used for displaying the user interface. The Controller is encapsulated in `PosController.java`.

When a user adds a product to the cart, the cart's state changes. The controller manipulates the Model to update the cart, and after the update, it refreshes `index.html` to reflect the changes. `index.html` is solely concerned with display and does not handle any business logic. This separation of internal business logic from the user interface makes the application more efficient to manage, and the code easier to maintain and extend.



Related demo videos :  [click here](https://www.bilibili.com/video/BV1Am421n7YM/?vd_source=4985f83853fea5fcd090f8f95973265a)

