package com.example.demo.repository;

import com.example.demo.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Интерфейс репозитория записей с методами нахождения сущностей/списка сущностей (CRUD операции).
 */
public interface IReservationRepository extends CrudRepository<ReservationEntity, Long> {
     /**
      * Метод, возвращающий список записей для определенного сервиса.
      * @param service Сервис, записи которого будут возвращены.
      * @return Возвращает список сущностей ReservationEntity (записи).
      */
     List<ReservationEntity> findByService(String service);

     /**
      * Метод, возвращающий список записей по заданному сервису и дате.
      * @param service Сервис, записи которого будут возвращены.
      * @param date Время, в котором находятся записи.
      * @return Возвращает список сущностей ReservationEntity (записи).
      */
     List<ReservationEntity> findByServiceAndDateTime_Date(String service, Long date);

     /**
      * Метод, проверяющий наличие записи на заданное время и дату по сервису.
      * @param date Дата, которая должна быть проверена.
      * @param time Время, которое должно быть проверено.
      * @param service Проверяемый сервис.
      * @return Возвращает Boolean - true, если запись существует и false соотв.
      */
     Boolean existsByDateTime_DateAndDateTime_TimeAndService(Long date, String time,
                                                                          String service);

     Boolean existsByStudentDocumentAndDateTime_DateAndDateTime_Time(Long studentDocument,
                                                                     Long date, String time);
}
