package com.vn.service.impl;

import com.vn.entities.Car;
import com.vn.repository.CarRepository;
import com.vn.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    public Car findCarByLicensePlate(String plateNumber) {
        return carRepository.findCarByPlateNumber(plateNumber);
    }
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
    @Override
    public Car findById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }
    @Override
    public List<Car> findCarsBelongToUser(Integer id) {
        return carRepository.findCarsByMemberId(id);
    }
    @Override
    public Page<Car> listCarByMemberId(Integer id, Pageable pageable) {
        return carRepository.findByMemberId(id,pageable);
    }
    public Page<Car> listAll(int pageNumber, String sortField, String sortDir, Integer id) {
        Sort sort = Sort.by("price");
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(pageNumber - 1,4,sort);
        return carRepository.findByMemberId(id,pageable);
    }
    @Override
    public void update(Car car) {
        carRepository.save(car);
    }
    @Override
    public boolean delete(Integer id) {
        carRepository.deleteById(id);
        return true;
    }
    @Override
    public Car findCarById(Integer id) {
        return carRepository.findCarById(id);
        }
    @Override
    public List<Car> searchCar(String province, LocalDateTime fromTime) {
        return carRepository.findByProvince(province, fromTime);
    }
}
