package com.fluffy.courseapidata.course;

import com.fluffy.courseapidata.topic.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> {
    public List<Course> findByTopicId(String topicId);
}
