package com.fluffy.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")//how to get a single resource using id
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

//    @RequestMapping("/topic/{foo}")//if variable is different from argument
//    public Course getTopic(@PathVariable("foo") String id){
//        return topicService.getTopic();
//    }


    @RequestMapping(method = RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);

    }

    @RequestMapping(method= RequestMethod.PUT,value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id ){//combination of POST and single resource get
        topicService.updateTopic(topic,id);

    }

    @RequestMapping(method= RequestMethod.DELETE,value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }


}
