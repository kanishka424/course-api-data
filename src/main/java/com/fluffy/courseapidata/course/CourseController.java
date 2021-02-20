package com.fluffy.courseapidata.course;

import com.fluffy.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")//here we only care about the course id because it is the primary key,no need to worry about topicId
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

//    @RequestMapping("/topic/{foo}")//if variable is different from argument
//    public Course getCourse(@PathVariable("foo") String id){
//        return courseService.getTopic();
//    }


    @RequestMapping(method = RequestMethod.POST,value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));//Not a full copy instance but it's fine at this stage
        courseService.addCourse(course);

    }

    @RequestMapping(method= RequestMethod.PUT,value="/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){//combination of POST and single resource get
        course.setTopic(new Topic(topicId," ",""));
        courseService.updateCourse(course);

    }

    @RequestMapping(method= RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }


}


//====================================NOTE======================================================
//how the URL given in addCourse check again
