# IBM SkillsBuild App

## Description
The IBM SkillsBuild App enhances IBM's SkillsBuild platform with gamification features. Users can track their progress through activities and earn medals and achievements. Key features include user authentication, activity tracking, user profiles, leaderboards, reviews, and customizable avatars, promoting engagement and interactive learning. The project utilizes Spring Boot, JDBC via MySQL, and RESTful web services to provide a robust and interactive platform.

## Key Features
- **User Authentication**: Secure login and registration using Spring Security.
- **Activity Tracking**: Track progress through various SkillsBuild activities.
- **User Profiles**: Manage user profiles with customizable avatars.
- **Leaderboards**: Compete with other users and view leaderboards.
- **Reviews**: Submit and view reviews for different courses.
- **Gamification**: Earn medals and achievements to enhance user engagement.

## Project Setup Instructions
Follow these steps to set up and run the project:

### 1. Database Configuration
1. **Create MySQL Database**:
   - Create a database named `co2103db` in your MySQL server.
   - Alternatively, you can use a different database name and update the configuration accordingly.

2. **Update `application.properties`**:
   - Locate the `application.properties` file in your project.
   - Ensure the following lines are included and updated with your database details:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/co2103db
     spring.datasource.username=co2103
     spring.datasource.password=password
     ```
   - Replace `co2103db`, `co2103`, and `password` with your actual database name, username, and password if they are different.

### 2. Running the Application
1. **Run the Main Class**:
   - Locate and run the `IBMApplication.java` file.
   - This will start the application.

### 3. Accessing the Application
1. **Open in Browser**:
   - Open a new incognito window in your web browser.

2. **Registration and Login**:
   - To register a new account, navigate to: `http://localhost:8080/register`
   - To use a pre-existing account, go to: `http://localhost:8080/login`
   - Use the following credentials:
     - **Username**: guest
     - **Password**: password

### 4. Features Access
- Once logged in, you will have full access to all features of the project.
- If you have any issues or questions about this project, please feel free to contact me at: osman.temirkhanov@gmail.com

## Detailed File Descriptions
### Java Classes
**AuthController.java**:
Handles user authentication operations including login and registration.

**AuthValidator.java**:
Validates authentication-related data.

**CourseController.java**:
Manages course-related operations including creating and listing courses.

**DashboardController.java**:
Handles requests related to the user dashboard.

**LeaderboardController.java**:
Manages operations related to the leaderboard.

**MainController.java**:
Manages the main application routes, such as the home page.

**ProfileController.java**:
Manages user profile operations.

**ReviewController.java**:
Handles operations related to course reviews.

**IBMApplication.java**:
The main class that starts the application.

**Avatar.java**:
Represents the user's avatar with customizable features.

**Badge.java**:
Represents badges that users can earn.

**CourseAttempt.java**:
Tracks attempts made by users to complete courses.

**Courses.java**:
Represents the different courses available in the application.

**Review.java**:
Manages the reviews submitted by users for courses.

**Role.java**:
Represents user roles within the application.

**UserEntity.java**:
Represents the user entity in the database.

**User_Badge.java**:
Maps users to the badges they have earned.

### Java Repository Classes

**AvatarRepository.java**:
Repository interface for managing avatar entities.

**BadgeRepository.java**:
Repository interface for managing badge entities.

**CourseAttemptRepository.java**:
Repository interface for managing course attempt entities.

**CoursesRepository.java**:
Repository interface for managing course entities.

**ReviewRepository.java**:
Repository interface for managing review entities.

**RoleRepository.java**:
Repository interface for managing role entities.

**UserBadgeRepository.java**:
Repository interface for managing user-badge relationships.

**UserRepository.java**:
Repository interface for managing user entities.


## Installation and Usage
1. **Clone the repository**:
   ```sh
   git clone https://github.com/osman789g/ibm-skillsbuild-app.git

2. **Navigate to the project directory:**:
   ```sh
   cd ibm-skillsbuild-app

3. **Build and run the application:**
 - Use your preferred Java IDE or build tool to compile and run the application.
 - Ensure your environment is configured to support JSPs and Spring MVC.

4. **Access the appication:**
 - Open a web browser and navigate to http://localhost:8080 to view the application.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License.

## Contact
For any inquiries or feedback, please contact [osman.temirkhanov@gmail.com].
