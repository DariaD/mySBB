package servises;

import com.jpa.entity.Schedule;
import com.jpa.entity.Station;
import com.jpa.entity.Train;
import com.jpa.servises.StationServices;
import com.jpa.servises.ScheduleService;
import com.jpa.servises.TrainServices;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Дарья on 06.03.2015.
 */
public class StopStationTest {
    ScheduleService stopService = new ScheduleService();
    TrainServices trainService = new TrainServices();
    StationServices stationService = new StationServices();

//    @Test
//    public void testSaveRecord() throws Exception {
//        Schedule stop = new Schedule();
//
//        Date stopDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2015-03-15 18:30:00");
////        Date stopDate = new Date(2015, 3, 15);
////        stopDate.setTime(Time.valueOf("15:42:0000").getTime());
//        stop.setDate(stopDate);
//
//        Train train = trainService.get(2);
//        stop.setTrain(train);
//        Station station = stationService.get(3);
//        stop.setStation(station);
//        stop.setAvPlases(train.getPlases() - 15);
//        //Записали в БД
//        StopStation stopStation = stopService.add(stop);
//
//        //Вывели записанную в БД запись
//        System.out.println(stopStation.toString());
//    }

//    @Test
//    public void testDeleteRecord() throws Exception {
//        //Создаем автомобиль для записи в БД
//        Train train1 = new Train();
//        train1.setName("Ferrari");
//        train1.setPlases(100);
//
//        //Записуем его в БД
//        Train train = service.add(train1);
//
//        //Удвлем его с БД
//        service.delete(train.getId());
//    }
//
//    @Test
//    public void testSelect() throws Exception {
//        //Создаем автомобиль для записи в БД
//        Train train1 = new Train();
//        train1.setName("Lev Tolstoy");
//        train1.setPlases(300);
//
//        //Записываем в БД
//        Train train = service.add(train1);
//
//        //Получние с БД Citroen‎
//        Train trainFromDB = service.get(train.getId());
//        System.out.println(trainFromDB);
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        //Создаем автомобиль для записи в БД
//        Train train1 = new Train();
//        train1.setName("Mirrow");
//        train1.setPlases(50);
//
//        //Записываем в БД
//        train1 = service.add(train1);
//
//        train1.setPlases(0);
//
//        //Обновляем
//        service.update(train1);
//
//        //Получаем обновленую запись
//        Train train = service.get(train1.getId());
//        System.out.println(train);
//    }
//
//    @Test
//    public void testGetAll(){
//        //Создаем автомобиль для записи в БД
//        Train train1 = new Train();
//        train1.setName("Lexus");
//        train1.setPlases(300);
//
//        //Создаем автомобиль для записи в БД
//        Train train2 = new Train();
//        train2.setName("Fiat");
//        train2.setPlases(200);
//
//        //Создаем автомобиль для записи в БД
//        Train train3 = new Train();
//        train3.setName("Porsche");
//        train3.setPlases(150);
//
//        //Сохраняем все авто
//        service.add(train1);
//        service.add(train2);
//        service.add(train3);
//
//        //Получаем все авто с БД
//        List<Train> trains = service.getAll();
//
//        //Выводим полученый список авто
//        for(Train c : trains){
//            System.out.println(c);
//        }
//    }

}
