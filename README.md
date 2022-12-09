# Note: Some of our tests initiated screens but action cannot close the message dialog, the Github Classroom Workflow failes but all the implementition, including the tests themselves, are correct.

# Welcome to FOODQEE

Are you a food lover who is looking to try some new restaurants? Are you a restaurant owner who is seeking more customers? Have you ever been annoyed by the huge line up to your favorite food truck or the unpleasant wait you have to stand by in cold winter? If any of these applies to you, Skip-the-Line is here to help! 

## Introduction
In this project, we aim to provide a platform for both customer and restaurant owners to place and process food orders. Customers are able to browse and search for the restaurant of their preference, add items from the menu of that restaurant, and place the order. Restaurant owners are able to upload and edit their menus, see the list of orders that have been placed and process those orders by changing the order status. 

More details will be introduced in the next few sections of this document.

## How to Run  
1. Run the file named `AppRun` and a JFrame window will pop out, this is our welcome screen.
2. The window can be closed by clicking on the top left/right corner(depending on Mac or Windows) as you would do to all other windows. 
3. The components will navigate between each other on click according to their functionalities.
4. Note that there are also runnable files in some of the use cases, these are used to run the use cases separately. They are very helpful when doing UI design since displaying a specific screen does not require navigating to that screen from the very beginning. 

## Screens and Features
### 1. Welcome Screen. 

<img width="968" alt="Screen Shot 2022-12-08 at 4 04 27 PM" src="https://user-images.githubusercontent.com/94703030/206567356-c56a689e-ecb0-4c43-969e-7db6cc672e7d.png">

- This screen is the first screen that shows up when the program is successfully runned. 
- It contains a simple greeting message and two buttons used for register and login. 
- We support registering two different types of account: user and restaurant. 
- Login and Register will both direct you to a separe window. 
- Note that the login is case sensitive, that means try logging in as a restaurant with the user crediential will fail.
- You can try to register new account or login with our sample account given in the table below: 

<p align="center">

|               | username      | password      |
| ------------  | ------------- | ------------- |
| Restaurant    | yinuo's res   | 123456        |
| User          | davidlin123   | lzy123456     | </p>

### 2. Login/Register Window.

- Depending on what action is taken on the previous screen, the login or register window will be called and allows users to log in to their existing account or register a new account. 
- The login window should look like the one one the right.
- Enter the username and password, the click on "login as restaurant" or "login as user". "Cancel" will take you back to the welcome screen.
- When the given cridentials are correct, there will be a success message dialog. It may also says "You need to verify" if the account is not verified, more details on this in the next section.
- Closing the message dialog will direct you to the homepage (Restaurant homepage or User homepage).
- New Account registration is also divided by the type of user, with the screenshot on the left corresponding to user registeration, and the one onthe right is restaurant registeration, which requires a set of different information.

![Untitled_Artwork](https://user-images.githubusercontent.com/94703030/206567856-9a92f0e1-6e37-4fbc-829a-4c39b8f4ebeb.png)


### 3. Verification Window.
- New users need to verify their account before using this platform. In this window, users can request a verification code being sent to their entered email. After the user has reviewed the code and entered it into the field provided, it will be compared with the code sent. Successful match will change the status of the account to "verified". 
- Note that the verification code expires in 5 minutes from the time it was issued。
- Entering incorrect or expired verification code will not pass the verification.

<img width="859" alt="Screen Shot 2022-12-08 at 4 16 54 PM" src="https://user-images.githubusercontent.com/94703030/206569373-ad43c9bb-5a2d-4309-b61c-490b80065845.png">

### 4. Restaurant/Customer homepage. 
<img width="335" alt="Screen Shot 2022-12-08 at 12 13 58 AM" src="https://user-images.githubusercontent.com/94703030/206364282-10ae2399-f5a7-44af-834e-b8335696677b.png"><img width="335" alt="Screen Shot 2022-12-08 at 12 28 05 AM" src="https://user-images.githubusercontent.com/94703030/206365453-837d706a-2037-42e1-b18a-8f5394d5bbc8.png"><img width="335" alt="Screen Shot 2022-12-08 at 12 28 10 AM" src="https://user-images.githubusercontent.com/94703030/206364364-79dfd52d-b40e-452a-8d54-6451a8c0fb8e.png">

<img align="right" width="265" alt="Screen Shot 2022-12-08 at 12 39 52 AM" src="https://user-images.githubusercontent.com/94703030/206366106-b25f7854-95e6-4ce5-80ed-dffc4f5dd4d2.png">


- The restaurant homepage consists of the following 3 different tabs:
- Order History: Restaurant owners will be able to view the orders received and change the status of the order from this page. Status includes received, preparing, ready for picked up, picked up, order completed, and cancelled. Food items, quantity, total revenue can be seen if "view details" is clicked. 
- Menu: The current menu of this restaurant. It also supports editing the menu by add, delete items, or modify the information of existing food items. Add and Edit will be done in seperate screen.
- Profile: Shows the account information. Restaurant owners can modify all informations on this page, including the password, and logout of the acount.
- ***When an user placed an order to the current restaurant, there will be a pop up message "You have a new order".***

- The user homepage consists of the following 4 different tabs:


<img width="500" alt="Screen Shot 2022-12-08 at 12 54 44 AM" src="https://user-images.githubusercontent.com/94703030/206368818-025630a3-7505-40f6-b3c1-43e10285fd0d.png"><img width="500" alt="Screen Shot 2022-12-08 at 12 56 02 AM" src="https://user-images.githubusercontent.com/94703030/206368853-0383eea9-b0e7-41af-b2cd-bfdc301303df.png"><img width="500" alt="Screen Shot 2022-12-08 at 12 56 19 AM" src="https://user-images.githubusercontent.com/94703030/206368930-ed824532-8d43-433e-8a94-ab2265fa9cc7.png"><img width="500" alt="Screen Shot 2022-12-08 at 12 56 25 AM" src="https://user-images.githubusercontent.com/94703030/206368944-71edf289-6a6a-4ae6-b956-839f127dedda.png">

- Restaurants: Displays all restaurant in the platform. The search bar allows fuzzy search of keywords. By clicking in "Details", there will be a separate window of the restaurant's menu, from there the user can add items to the cart.
- Shopoing Cart: Displays items that has been added to the cart, checking out will place the order.
- Order History: All orders that the current user has placed. User can make review to past orders and view the details(items, total price and etc.)
- Profile: Acount information of the current user. Can modify the acount info and password, as well as log out.

## Database
In this project, we used MongoDB as our database, which is a document-oriented NoSQL database. We created 6 different collections to store our data: 
<img align="right" width="600" alt="Screenshot 2022-11-22 at 12 39 14 AM" src="https://user-images.githubusercontent.com/94703030/203233617-86a474e9-7007-4e2d-84bd-0f30f125e7d5.png">
1. AuthInfo: Stores the username and password for all users(restaurant owners and customers), along with an unique user id.
2. Menus: Stores menus and the restaurant(id) of this menu.
3. Orders: Stores all orders with their: status, time placed, customer(id) that placed the order, restaurant(id) that receives the order.
4. Restaurants: Stores restaurant name, location, email, phone, and a unique restaurant id.
5. Users: Stores customer's name, email, account verification status and an unique user id.
6. Verification: Stores the verification code that has been set, with the user(id) that receives the code and the time it was requested.

## Architecture and Design Pattern
We construct our project in a way that it is consistent with both the Clean Architecture and SOLID principle. The UI and algorithms also interact in a way that follows the pattern MVPC Model-View-Presenter-Controller design pattern. Each use case has its own package and all components, interactors, presenters and controllers are organized in the package of the by use case.

## Future Enhencements
- Payment System.
- Allow uploding photos to the menu.
- Estimated wait time calculator for users.
- And more.

## Use of GitHub features
1. We use the discussion page to open up the floor for everyone to express their thoughts and ask questions. Important deadlines and decisions are also posted there using the announcement feature. 
2. The issues are used to track our progress of implementing the project. We have one issue for each use case in the beginning, assigned to each member for implementation. During the process, whenever new problems or ideas arise, we make a new issue to take note of and address it.
3. Branching: we made 1 branch for every single feature. Each time the new commit from a branch is merged to the main, that branch will not be used anymore. This workflow has prevented us from the possible mess caused by frequent pull and merge.
4. Merging and Pull request: We assigned 1 member to keep an eye on the pull requests and merge in the pull requests after having confirmed that there's no conflict and every member in the team is aware of the new changes. 

## Closing Words
Thank you so much for taking the time to read over this document. We also hope to be able to continue this project in the future, adding more features and functionalities and we will appreciate any comments and feedbacks!

Team members: Allen Xu, Leo Liu, Yinuo Zhao, David Lin, Jackon Su, Kevin Yang, Peter Yang.


