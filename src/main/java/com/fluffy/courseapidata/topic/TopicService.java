package com.fluffy.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
//    private List<Course> topics=new ArrayList<>(Arrays.asList(new Course("1","topic1","topic 1 desc"),
//            new Course("2","topic2","topic 2 desc"),
//            new Course("3","topic3","topic 3 desc")));

    @Autowired
    TopicRepository topicRepository;


    public List<Topic> getAllTopics(){

       List<Topic> topicList=new ArrayList<>();

       for(Topic topic:topicRepository.findAll()){
           topicList.add(topic);
       }
       return topicList;

//        return topics;
    }

    public Topic getTopic(String id){
        for(Topic topic:topicRepository.findAll()){
            if(topic.getId().equals(id)){
                return topic;
            }
        }
        System.out.println("No such topic");
        return null;
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    };

    public void addTopic(Topic topic){
        topicRepository.save(topic);

        //topics.add(topic);
    }

    public void updateTopic(Topic topic,String id){
        topicRepository.save(topic);//no need of id if the instance contains the key(id)
//        for (int i=0;i<topics.size();i++){
//            Course t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
    }


    public void deleteTopic(String id){
        topicRepository.deleteById(id);
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
