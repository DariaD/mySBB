package servises;

import com.jpa.entity.Station;
import com.jpa.servises.StationServices;
import org.junit.Test;

import java.util.List;

/**
 * Created by Дарья on 05.03.2015.
 */
public class StationServiceTest {

       StationServices service = new StationServices();

        @Test
        public void testSaveRecord() throws Exception {
            //Создаем gjtpl для записи в БД
            Station station1 = new Station();
            station1.setName("Saarbrucken");

            //Записали в БД
            Station station = service.add(station1);

            //Вывели записанную в БД запись
            System.out.println(station);
        }

        @Test
        public void testDeleteRecord() throws Exception {
            //Создаем автомобиль для записи в БД
            Station station1 = new Station();
            station1.setName("Zurich");

            //Записуем его в БД
            Station train = service.add(station1);

            //Удвлем его с БД
            service.delete(train.getId());
        }

        @Test
        public void testSelect() throws Exception {
            //Создаем автомобиль для записи в БД
            Station station1 = new Station();
            station1.setName("Frankfurt");

            //Записываем в БД
            Station train = service.add(station1);

            //Получние с БД Citroen‎
            Station trainFromDB = service.get(train.getId());
            System.out.println(trainFromDB);
        }

        @Test
        public void testUpdate() throws Exception {
            //Создаем автомобиль для записи в БД
            Station station1 = new Station();
            station1.setName("Geneva");

            //Записываем в БД
            station1 = service.add(station1);

            //Обновляем
            service.update(station1);

            //Получаем обновленую запись
            Station station = service.get(station1.getId());
            System.out.println(station);
        }

        @Test
        public void testGetAll(){
            //Создаем автомобиль для записи в БД
            Station station1 = new Station();
            station1.setName("Bern");

            //Создаем автомобиль для записи в БД
            Station station2 = new Station();
            station2.setName("Koblenz");

            //Создаем автомобиль для записи в БД
            Station station3 = new Station();
            station3.setName("Amsterdam");

            //Сохраняем все авто
            service.add(station1);
            service.add(station2);
            service.add(station3);

            //Получаем все авто с БД
            List<Station> stations = service.getAll();

            //Выводим полученый список авто
            for(Station station : stations){
                System.out.println(station);
            }
        }
    }

