Report:

Brief summary:
This app is aiming to provide a calendar and pomodoro timer for people to plan their daily work. The idea of this timer is based on pomodoro technique, which uses a timer to break work into intervals. Each completed task will be marked as a star (differ by color) in each user’s skymap.

Each group member has been working on:
Shuyang Qiu & Purui: Responsible for “Calandar” part work “Goals part with Yushan.
Boyu Zhu: Responsible for “Pomodoro Timer” part
Yihang Luo: Responsible for “stats” part
Yushan Xie: Responsible for “users” part (user-login and store data under users), work on ‘Goals’  with Shuyang

Clean Architectures & SOLID principle:

Pomodoro Timer:
There is only one class for the Pomodoro Timer, which combines the entity and the use cases together. We are planning to break the Pomodoro class into three different classes using the MVC architecture pattern.
The Pomodoro class follows the SOLID principles in a way that the only reason to change the class is if someone needs to change the setting or add some method to the timer, and the class is open for adding extension in order to make the timer have more functions. Since there is no abstraction, parent class and interface implemented, the rest LID principles are satisfied automatically.
For the pomodoro timer part, we are planning to add some methods to let the user set the focusing and resting time of the timer, and popping out a notification when the cycle has finished. In addition, we will try to let the user choose some background music if they want while the timer is counting down, and also we will add some background pictures to let the user choose.

User:
We used the MVC model for the Users login part. This design pattern can bring the same advantages as Clean architecture brings to us but it is more suitable for a mobile app. MVC stands for Model, View and Controller. Details are shown as following:
Model: Model directly manages the data, logic and rules of the application. In the User-login part, Model sets the rules for user's email address and their password. It is responsible for managing data which is updating the app to reflect data.
View: It is responsible for how we can display the user-login data to the User screen. It is for presenting data in a particular format. In the User login part, it is used to show whether a user logs in successfully or not.
Controller (Like the Controllers in Clean Architecture): It receives data from View and notify Model about the data. For example, after receiving a user's action from View, it needs to justify the length of the password that user enters. If its length is shorter than 12 chars, then it needs to notify the Model. Model will then update the result.
The Userlogin class follows the SOLID principles in a way that every class has a single responsibility. For example, for Model class, it only needs to handle the data of the user's email address and password. If I need to change the requirement of setting a password (ex: changing its length requirement), then I will only need to make changes in Model class. Also, it follows the Interface Segregation principle. Each interface is fairly small which allows users to not end up depending on things they don’t need.
In the future, we will build a better connection among user-login, Calendar and Stats which allows users to jump to Calendar or view their stats smoothly.

Stats:
I suppose to use the MVC architecture for the bubble chart part, because the view and module of the code are very clear. The bubble chart will directly show how much time the user spends on each work by presenting the size of each “star” it contains.
MVC architecture contains three parts. For the model, it gives rules to the data we get from the database with what the bubble chart actually needs, such as exactly the time we consume on each subject.
For the view, it is responsible for using the database we get from the finished goals to show what we have completed. It will include plenty of bubbles, which present the stars we want in our plan, with different sizes and names of the finished goals.
For the controller, I am not very sure about this part because by the definition picture, the controller is in the same circle area with API, which I will use as an external library to make the bubble chart more vivid. So can the MyAndroidChart library be a kind of controller in the MVC architecture? Or the database can be the controller because it should be often justified every time after one individual has finished their goal and there is going to appear a new “star” on the bubble chart?

Goals + Calendar
Goals and calendar were created using the MVP architecture. The goals class acts as a model, containing only data. The activity classes act as views and they are updated by their corresponding presenter classes. User input is passed from activity classes to presenter classes which then interacts with the models.
The Goals class uses the builder pattern since it can potentially take many parameters.
In the future, we will refactor some of the classes to better adhere to clean architecture. For example, part of the user data, the goals list, is currently being stored in the calendar activity and should be moved to the User class since data belongs in a model class, not a view. Additionally, there is still some logic in the activity classes which should be moved to presenter classes.

General future plan:
In the future, we are going to make the connection of the four main parts of our project (calendar, pomodoro timer, statistics, user) more smooth and logical, and we will also improve our UI by adding some pictures and trying to use some other tools provided in Android Studio.

