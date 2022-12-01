# Welcome to Skip-the-Line

Are you a food lover who is looking to try some new restaurants? Are you a restaurant owner who is seeking more customers? Have you ever been annoyed by the huge line up to your favorite food truck or the unpleasant wait you have to stand by in cold winter? If any of these applies to you, Skip-the-Line is here to help! 

## Introduction
In this project, we aim to provide a platform for both customer and restaurant owners to place and process food orders. Customers are able to browse and search for the restaurant of their preference, add items from the menu of that restaurant, and place the order. Restaurant owners are able to upload and edit their menus, see the list of orders that have been placed and process those orders by changing the order status. 

More details will be introduced in the next few sections of this document.

## How to Run  
1. Run the file named `AppRun` and the Jframe window will pop out. 
2. The window can be closed by clicking on the top left/right corner(depending on Mac or Windows) as you would do to all other windows. 
3. The screens will navigate between each other on click according to their functionalities.
4. **Our program is not finished at this point so it CANNOT run by following the above instruction. Please run each individual screen.**

## Screens
### 1. Welcome Screen. 
[Screenshots to be add]
This screen is the first screen that shows up when the program is successfully runned. It contains a simple greeting message and two buttons used for register and login.

### 2. Login/Register Window.
[Screenshots to be add]
Depending on what action is taken on the previous screen, the login or register window will be called and allows users to login to their existing account or register a new account. There will be responsive messages when the user login information is invalid(username does not exist in the database or password doesn't match with the given username). 

### 3. Verification Window.
[Screenshots to be add]
New users need to verify their account before using this platform. In this window, users can request a verification code being sent to their entered email. After the user has reviewed the code and entered it into the field provided, it will be compared with the code sent. Successful match will change the status of the account to "verified".

### 4. Restaurant/Customer homepage. 
[Screenshots to be add] 
Depending on what type of users you logged in as, the screen will display the homepage for that user. 

- For restaurant owners, the home screen consists of a list of orders that are currently in queue, along with the status of the orders. The navigation bar at the bottom navigates to the Menu Editing Page and the order history page.

- For customers, the home screen contains the list of restaurants, and a search bar at the top. By entering the name of the restaurant, a list of restaurants that satisfies the key words will show up. The navigation bar at the bottom will bring you to the shopping cart page or order history page.

### 5. Restaurant Owner: Menu Editing Page.
[Screenshots to be add] 
This screen is only provided to restaurant owners. The current menu saved in the database will be shown here. Users are able to edit the menu by adding or removing food items, as well as edit individual food item's name, price, description and category.

### 6. Customer: Shopping Cart Page
[Screenshots to be add] 
This screen is only provided to customers. The current items that have been added to the shopping card will be shown here. Users are able to edit the cart by adding or removing items, and edit the quantity of the items. 

### 7. Restaurant Owner/Customer: Order History Page.
[Screenshots to be add] 
Both customers and restaurant owners will have this access to this page, directed from the home page navigation bar. 
- For restaurant owners, the order history contains the list of orders that the restaurant has completed, from all customers, sorted by time with the most recent order at the top. 
- For customers, the order history contains the list of orders that the user has placed, from all restaurants, sorted by time with the most recent order at the top.

### 8. More Screens to be added.

## Database
In this project, we used MongoDB as our database, which is a document-oriented NoSQL database. We created 6 different collections to store our data: 
<img width="1322" alt="Screenshot 2022-11-22 at 12 39 14 AM" src="https://user-images.githubusercontent.com/94703030/203233617-86a474e9-7007-4e2d-84bd-0f30f125e7d5.png">
1. AuthInfo: Stores the username and password for all users(restaurant owners and customers), along with an unique user id.
2. Menus: Stores menus and the restaurant(id) of this menu.
3. Orders: Stores all orders with their: status, time placed, customer(id) that placed the order, restaurant(id) that receives the order.
4. Restaurants: Stores restaurant name, location, email, phone, and a unique restaurant id.
5. Users: Stores customer's name, email, account verification status and an unique user id.
6. Verification: Stores the verification code that has been set, with the user(id) that receives the code and the time it was requested.

## Architecture and Design Pattern
We construct our project in a way that it is consistent with both the Clean Architecture and SOLID principle. The UI and algorithms also interact in a way that follows the pattern MVC Model-View-Controller design pattern. Each use case has its own package and all screens, interactors, presenters and controllers are organized in the package of the by use case.

## Use of GitHub features
1. We use the discussion page to open up the floor for everyone to express their thoughts and ask questions. Important deadlines and decisions are also posted there using the announcement feature. 
2. The issues are used to track our progress of implementing the project. We have one issue for each use case in the beginning, assigned to each member for implementation. During the process, whenever new problems or ideas arise, we make a new issue to take note of and address it.
3. Branching: we made 1 branch for every single feature. Each time the new commit from a branch is merged to the main, that branch will not be used anymore. This workflow has prevented us from the possible mess caused by frequent pull and merge.
4. Merging and Pull request: We assigned 1 member to keep an eye on the pull requests and merge in the pull requests after having confirmed that there's no conflict and every member in the team is aware of the new changes. 

## Closing Words
Thank you so much for taking the time to read over this document. Our project is still in the progress of implementation and may not support all of the functionalities planned at this point, but we will work together to make it happen. We also hope to be able to continue this project in the future, adding more features and functionalities. We will appreciate any comments and feedback on this project!


