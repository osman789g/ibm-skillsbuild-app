package com.example.newone;

import com.example.newone.model.*;
import com.example.newone.repos.AvatarRepository;
import com.example.newone.repos.BadgeRepository;
import com.example.newone.repos.CourseAttemptRepository;
import com.example.newone.repos.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IBMApplication implements CommandLineRunner {

    @Autowired //Dashboard
    private CoursesRepository coursesRepository;

    @Autowired // Security
    private com.example.newone.repos.UserRepository UserRepository;

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private CourseAttemptRepository courseAttemptRepository;

    public static void main(String[] args) {
        SpringApplication.run(IBMApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Dashboard Generation

        Courses course1 = new Courses();
        course1.setCoursename("Getting Started with Enterprise-grade AI");
        course1.setLink("https://www.ibm.com/academic/topic/artificial-intelligence?ach_id=256c0f15-a1f2-4b9e-b672-63f4d8b20018");
        course1.setTopic("Artificial Intelligence");

        course1 = coursesRepository.save(course1);

        Courses course2 = new Courses();
        course2.setCoursename("Fundamentals of Sustainability and Technology");
        course2.setLink("https://www.ibm.com/academic/topic/artificial-intelligence?ach_id=730ea2cf-c91f-4e4a-b4c9-b28eb26e979b");
        course2.setTopic("Artificial Intelligence");

        course2 = coursesRepository.save(course2);

        Courses course3 = new Courses();
        course3.setCoursename("Building Trustworthy AI Enterprise Solutions");
        course3.setLink("https://www.ibm.com/academic/topic/artificial-intelligence?ach_id=a0c78296-18d1-4e92-bebe-d31add4862e8");
        course3.setTopic("Artificial Intelligence");

        course3 = coursesRepository.save(course3);

        Courses course4 = new Courses();
        course4.setCoursename("Getting Started with Enterprise Data Science");
        course4.setLink("https://www.ibm.com/academic/topic/data-science?ach_id=8d72f699-26ac-4542-a701-6b69f50e6b5f");
        course4.setTopic("Data Science");

        course4 = coursesRepository.save(course4);

        Courses course5 = new Courses();
        course5.setCoursename("Machine Learning for Data Science Projects");
        course5.setLink("https://www.ibm.com/academic/topic/data-science?ach_id=2bdf0308-8170-455d-8936-9a036ea290a3");
        course5.setTopic("Data Science");

        course5 = coursesRepository.save(course5);

        Courses course6 = new Courses();
        course6.setCoursename("Developing Secure Software");
        course6.setLink("https://www.ibm.com/academic/topic/security?ach_id=5fa327da-d138-4893-989f-7f46e625ecab");
        course6.setTopic("IBM Security");
        course6 = coursesRepository.save(course6);

        Courses course7 = new Courses();
        course7.setCoursename("Security Operations Center in Practice");
        course7.setLink("https://www.ibm.com/academic/topic/security?ach_id=23f032a6-87b9-4d60-9cff-dd18a089b324");
        course7.setTopic("IBM Security");
        course7 = coursesRepository.save(course7);

        Courses course8 = new Courses();
        course8.setCoursename("Cloud Computing Fundamentals");
        course8.setLink("https://www.ibm.com/academic/topic/cloud?ach_id=a97d681b-ef48-4d70-b3e8-9fd87894e3a1");
        course8.setTopic("IBM Cloud");
        course8 = coursesRepository.save(course8);

        Courses course9 = new Courses();
        course9.setCoursename("DevOps for Enterprise Business Agility");
        course9.setLink("https://www.ibm.com/academic/topic/cloud?ach_id=1249104d-a046-4299-92ab-40135364e4e2");
        course9.setTopic("IBM Cloud");
        course9 = coursesRepository.save(course9);




        // Security - User & Role generation(Testing)
        UserEntity user1 = new UserEntity();
        user1.setUsername("guest");
        user1.setPassword("password");
        user1.setEmail("guest@gmail.com");
        user1.setAvatar(1L);
        user1.setLevel(2);

        Role role1 = new Role();
        role1.setName("DEFAULT");

        user1.getRoles().add(role1);
        UserRepository.save(user1);

        // Create all the Badge objects for the badges needed
        Badge goldCompletion = new Badge("Gold Completion", "This user has completed at least 7 courses.", "/images/gold-medal.png");
        badgeRepository.save(goldCompletion);
        Badge silverCompletion = new Badge("Silver Completion", "This user has completed at least 4 courses.", "/images/silver-medal.png");
        badgeRepository.save(silverCompletion);
        Badge bronzeCompletion = new Badge("Bronze Completion", "This user has completed at least 1 course.", "/images/bronze-medal.png");
        badgeRepository.save(bronzeCompletion);
        Badge AIExpert = new Badge("AI Expert", "This user has completed all courses on Artificial Intelligence.", "/images/robot.png");
        badgeRepository.save(AIExpert);
        Badge DataExpert = new Badge("DS Expert", "This user has completed all courses on Data Science.", "/images/data.png");
        badgeRepository.save(DataExpert);
        Badge SecurityExpert = new Badge("Security Expert", "This user has completed all courses on Security.", "/images/security.png");
        badgeRepository.save(SecurityExpert);
        Badge CloudExpert = new Badge("Cloud Expert", "This user has completed all courses on Cloud Computing.", "/images/cloud.png");
        badgeRepository.save(CloudExpert);

        Avatar avatar0 = new Avatar();
        avatar0.setAvatarUrl("https://i.imgur.com/0mKMHqG.png");
        avatar0.setAvatarLevel(1);
        avatarRepository.save(avatar0);

        Avatar avatar1 = new Avatar();
        avatar1.setAvatarUrl("https://i.imgur.com/UWh4nHM.png");
        avatar1.setAvatarLevel(2);
        avatarRepository.save(avatar1);

        Avatar avatar2 = new Avatar();
        avatar2.setAvatarUrl("https://i.imgur.com/CrJhpyv.png");
        avatar2.setAvatarLevel(3);
        avatarRepository.save(avatar2);

        Avatar avatar3 = new Avatar();
        avatar3.setAvatarUrl("https://i.imgur.com/24YWWlb.png");
        avatar3.setAvatarLevel(4);
        avatarRepository.save(avatar3);

        Avatar avatar4 = new Avatar();
        avatar4.setAvatarUrl("https://i.imgur.com/mSfCkJu.png");
        avatar4.setAvatarLevel(5);
        avatarRepository.save(avatar4);

        CourseAttempt courseAttempt1 = new CourseAttempt();
        courseAttempt1.setCourseName("ABC");
        courseAttemptRepository.save(courseAttempt1);

        CourseAttempt courseAttempt2 = new CourseAttempt();
        courseAttempt2.setCourseName("DEF");
        courseAttemptRepository.save(courseAttempt2);

        CourseAttempt courseAttempt3 = new CourseAttempt();
        courseAttempt3.setCourseName("GHI");
        courseAttemptRepository.save(courseAttempt3);
    }

    
}
