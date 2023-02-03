package com.example.supplierservice.kafkaStram;

import com.example.supplierservice.model.Bill;
import com.example.supplierservice.model.ProductItem;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class service {
    @Bean
    public Supplier<Bill> billsSupplier()
    {
        System.out.println("je suis dans supliere");
        //Product product = inventoryServiceClient.findProductById(1L);
        ProductItem item=new ProductItem();
        item.setProductName("product");
        item.setProductId(1L);
        item.setPrice(5000);
        item.setQuantite(10);
        Collection<ProductItem> productItems=new ArrayList<>();
        productItems.add(item);
        return ()-> new Bill(null, new Date(),productItems , null, 1L);
    }

    @Bean
    public Function<Bill,Map<String,Double>> billFunction(){
        return (input)->{
            //System.out.println(input.getBillingDate());
            Map<String,Double> map=new HashMap<>();
            input.getProductItems().forEach(data->{
                map.put("C.D", data.getPrice()* data.getQuantite()*Math.random());
            });
            //System.out.println(map);
            return map;
        };
    }

    @Bean
    public Consumer<KeyValue<String,Double>> kStreamConsumer() {
        System.out.println("je suis dans consumer");
        return (input)->{
            System.out.println("consumer kstream:"+input);
        };
    }



    /*@Bean
    public Function<KStream<String,Double>,KStream<String,Double>> kStreamFunction()
    {
        return (input)->{
            return input
                    .filter((k,v)->v>100)
                    .groupBy((k,v)->k,Grouped.with(Serdes.String(),Serdes.Double()))
                    .windowedBy(TimeWindows.of(Duration.ofMillis(5000)))
                    .count(Materialized.as("bill-store"))
                    .toStream()
                    .mapValues(v-> v.doubleValue());
        };
    }*/

    /*ce bean permet de lire a partir d'un topic mentionné dans le fichier application.properties et ecrire des statistique dans un autre  topic mentionné dans le fichier application.properties
comme output avec un delai de commit fixée a 1s atravers l'option:
spring.cloud.stream.kafka.streams.binder.configuration.commit.interval.ms=1000
 */
/*    //@Bean
    public Function<KStream<String,Bill>,KStream<String,Long>> kStreamFunction(){
        return (input)->{
            return input
                    .filter((k,v)->v.getDuration()>100)
                    .map((k,v)->new KeyValue<>(v.getName(),0L))
                    .groupBy((k,v)->k, Grouped.with(Serdes.String(),Serdes.Long()))// cette fonction groupBy retourne un KTable
                    .windowedBy(TimeWindows.of(Duration.ofMillis(5000)))
                    .count(Materialized.as("page-count"))//persister les donnée par default kafka il vas stocker dans store qui porte le nom page count mais vous pouvez les stocker dans une base de donnée
                    .toStream()
                    .map((k,v)-> new KeyValue<>("=>"+k.window().startTime()+k.window().endTime()+k.key(),v));
        };
    }*/

/*    @Bean
    public Function<Bill,KStream<String,Long>> kStreamFunction()
    {
        return (input)->{
            System.out.println("3333333");
            System.out.println(input);
            return null;
        };
        *//*return (input)->{
            Map<String,Long> map=new HashMap<>();
            input.getProductItems().forEach(data->{
                if (map.containsKey(data.getProductName()))
                {
                    map.put(data.getProductName(), map.get(data.getProductName()+data.getQuantite()));
                }
                else {
                    map.put(data.getProductName(), (long) data.getQuantite());
                }
            });
            System.out.println(map);
            return (KStream<String, Long>) map;
        };*//*

    }*/







}
