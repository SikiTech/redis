package com.sikiapp.redis.mapper;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(StoreMapperTest.class);

//    @Autowired
//    private StoreMapper storeMapper;
//
//    @Test
//    public void selectList() {
//        List<Store> stores = storeMapper.selectList(Wrappers.<Store>lambdaQuery().gt(Store::getCombine, 3));
//        stores.forEach(o -> logger.debug(o.toString()));
//    }
//
//    @Test
//    public void insert() {
////        Store mmt = new Store().setName("MMT2").setService(ServiceEnum.FIVE).setCombine(5).setTasty(TastyEnum.ONE).setSpeed(SpeedEnum.FOUR);
////        assertThat(storeMapper.insert(mmt)).isGreaterThan(0);
//    }
//
//    @Test
//    public void selectListOrder() {
//        List<Store> stores = storeMapper.selectList(Wrappers.<Store>lambdaQuery().orderByAsc(Store::getCombine));
//        stores.forEach(o -> logger.debug(o.toString()));
//    }
//
//    @Test
//    public void selectListOrderEx() {
//        Page<Store> page = new Page<>(1, 5);
//        IPage<Store> storeIPage = storeMapper.selectPage(page, Wrappers.<Store>lambdaQuery().orderByAsc(Store::getCombine));
//        System.out.println(storeIPage);
//    }
//
//    @Test
//    public void selectMaps() {
//        List<Map<String, Object>> maps = storeMapper.selectMaps(Wrappers.<Store>lambdaQuery().orderByAsc(Store::getCombine));
//        System.out.println(maps);
//    }
//
//    @Test
//    public void testDelete() {
//        assertThat(storeMapper.deleteById(6007)).isGreaterThan(0);
//        assertThat(storeMapper.deleteBatchIds(Arrays.asList(6006, 6007))).isGreaterThan(0);
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "素食");
//        assertThat(storeMapper.deleteByMap(map)).isGreaterThan(0);
//        assertThat(storeMapper.delete(Wrappers.<Store>lambdaQuery().eq(Store::getName, "MMt")));
//    }
//

















}