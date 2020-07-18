package corentine.demo.controllers;

import corentine.demo.models.Exercise;
import corentine.demo.models.Item;
import corentine.demo.repository.ExerciseRepository;
import corentine.demo.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;


@Controller
public class ItemController {

    @Resource
    private ItemRepository itemRepo;
    @Resource
    private ExerciseRepository exerciseRepo;

//    @RequestMapping("/home/items")
//    public String displayAllItems(Model model){
//        model.addAttribute("item", itemRepo.findAll());
//        return "items";//can I change this to itemsView
//    }
//
//    @RequestMapping("/home/item/{id}")  //should this be /home/items{id}
//    public String displayItems(@PathVariable long id, Model model){
//        Optional<Item> retrievedItem = itemRepo.findById(id);
//        Item foundItem = retrievedItem.get();
//        model.addAttribute("item", foundItem);
//        return "itemsView"; //i think this needs to be itemView
//    }

    @RequestMapping({"/items"})
    public String displayAllItems(Model model){
        model.addAttribute("items", itemRepo.findAll());
        model.addAttribute("exercises", exerciseRepo.findAll());
        return "itemsView";
    }

//    @RequestMapping({"/items"})
//    public String displayAllItems(Model model, @PathVariable long id){
//        model.addAttribute("items", itemRepo.findAll());
//        model.addAttribute("exercises", exerciseRepo.findAll());
//        Optional<Item> retrievedItem = itemRepo.findById(id);
//        Item foundItem = retrievedItem.get();
//        model.addAttribute("item", foundItem);
//        return "itemsView";
//    }

//
//    @RequestMapping({"/items"})
//    public String displayAllItems(@PathVariable long id, Model model) {
//        Optional<Exercise> retrievedExercise = exerciseRepo.findById(id);
//        Exercise foundExercise = retrievedExercise.get();
//        model.addAttribute("exercise", foundExercise);
//        model.addAttribute("items", itemRepo.findAll());
//        model.addAttribute("exercises", exerciseRepo.findAll());
//        return "itemsView";
//    }


    @RequestMapping("/items/{id}")
    public String displaySingleItem(@PathVariable long id, Model model) {
        Optional<Item> retrievedItem = itemRepo.findById(id);
        Item foundItem = retrievedItem.get();
        model.addAttribute("item", foundItem);
        return "itemView";  //single itemView.html has not been created yet, may not even need it
    }

}
