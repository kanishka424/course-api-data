package com.fluffy.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
//    private List<Course> topics=new ArrayList<>(Arrays.asList(new Course("1","topic1","topic 1 desc"),
//            new Course("2","topic2","topic 2 desc"),
//            new Course("3","topic3","topic 3 desc")));

    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCourses(String id){

       List<Course> courses =new ArrayList<>();

//       courseRepository.findAll()
//               .forEach(courses::add);
        courseRepository.findByTopicId(id)
                .forEach(courses::add);
       return courses;

//       for(Course course : courseRepository.findAll()){
//           courseList.add(course);
//       }
//       return courseList;

//        return topics;
    }

    public Course getCourse(String id){
        for(Course course : courseRepository.findAll()){
            if(course.getId().equals(id)){
                return course;
            }
        }
        System.out.println("No such topic");
        return null;
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    };

    public void addCourse(Course course){
        courseRepository.save(course);

        //topics.add(course);
    }

    public void updateCourse(Course course){
        courseRepository.save(course);//no need of id if the instance contains the key(id)
//        for (int i=0;i<topics.size();i++){
//            Course t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,course);
//                return;
//            }
//        }
    }


    public void deleteCourse(String id){
        courseRepository.deleteById(id);
        //topics.removeIf(t->t.getId().equals(id));
    }

//    public void deleteTopic(String id){
//        for(Course topic:topics){
//            if(topic.getId().equals(id)){
//                topics.remove(topic);
//            }
//        }
//    }




}
