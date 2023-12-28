package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    /**
     * 준영속 엔티티를 수정하는 2가지 방법
     */

    // 영속성 컨텍스트에서 엔티티를 다시 조회한 후에 데이터를 수정하는 방법.
    // 트랜잭션 안에서 앤티티를 다시 조회, 변경할 값 선택 -> 트랜잭션 커밋 시점에 변경 감지가 동작해서 데이터베이스에 UPDATE SQL 실행
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity){

        Item findItem = itemRepository.findOne(itemId);

        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
    }
    // 병합(merge) 사용 - 병합은 준영속 상태의 엔티티를 영속 상태로 변경할 때 사용하는 기능.
    // 병합시 동작 방식을 간단히 정리
    // 1. 준영속 엔티티의 식별자 값으로 영속 엔티티를 조회한다.
    // 2. 영속 엔티티의 값을 준영속 엔티티의 값으로 모두 교체한다.(병합한다.)
    // 3. 트랜잭션 커밋 시점에 변경 감지 기능이 동작해서 데이터베이스에 UPDATE SQL이 실행
    // !! 변경 감지 기능을 사용하면 원하는 속성만 선택해서 변경할 수 있지만, 병합을 사용하면 모든 속성이 변경된다.
    // 병합시 값이 없으면 `null` 로 업데이트 할 위험도 있다. (병합은 모든 필드를 교체한다.)
    // 앤티티를 변경할 때는 항상 변경 감지를 사용하는 것이 좋다.
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
