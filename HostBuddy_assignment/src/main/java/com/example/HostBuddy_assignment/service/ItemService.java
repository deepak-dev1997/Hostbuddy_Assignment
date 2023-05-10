package com.example.HostBuddy_assignment.service;

import com.example.HostBuddy_assignment.entrydto.ItemEntryDto;
import com.example.HostBuddy_assignment.model.Item;
import com.example.HostBuddy_assignment.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public String addItem(ItemEntryDto itemEntryDto){
        String name=itemEntryDto.getName();
        String description= itemEntryDto.getDescription();
        Item item=new Item();
        item.setName(name);
        item.setDescription(description);
        itemRepository.save(item);
        return "Items added successfully";
    }

    public List<Item> viewAll() throws Exception{

        List<Item> listofItem=itemRepository.findAll();
        if(listofItem.size()==0) throw new Exception("items.notfound");
        return listofItem;
    }

    public List<Item> viewByKeword(String search){
        search= search.toLowerCase();
        List<Item> l1 = itemRepository.findAll();
        List<Item> l2 = new ArrayList<>();
        for(Item i : l1){
            String name=i.getName().toLowerCase();
            if(name.indexOf(search)!=-1){
                l2.add(i);
            }

        }
        return l2;
    }
}
