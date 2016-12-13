package edu.trial.itcompany;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sun.rmi.runtime.Log;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        InformationRecipientImpl p1 = new InformationRecipientImpl();
        // Возвращает сотрудников без проекта
        System.out.print("Сотрудники без проекта: " + p1.getListOfNotBusyEmployees().toString() + "\n");

        Employees sotr = p1.employees;

        //добавление в лист уникальных проектов
        ArrayList<String> nameProject = new ArrayList<String>();
        for (int i = 0; i < sotr.Employees.size(); i++) {
            for (int j = 0; j < sotr.Employees.get(i).getProjects().size(); j++) {
                if (!nameProject.contains(sotr.Employees.get(i).getProjects().get(j).getProjectName())) {
                    nameProject.add(sotr.Employees.get(i).getProjects().get(j).getProjectName());
                }
            }
        }

        //поиск сотрудников по проектам
        for (int i = 0; i < nameProject.size(); i++) {
            System.out.println("Название проекта: " + nameProject.get(i) + " Список сотрудников" + p1.getListOfEmployeeOnProject(nameProject.get(i)).toString());
        }
        System.out.print("\n");
        //Добавление в лист сотрудников
        ArrayList<String> sotrProject = new ArrayList<String>();
        for (int i = 0; i < sotr.Employees.size(); i++) {
            if (!sotrProject.contains(sotr.Employees.get(i).getPersonName())) {
                sotrProject.add(sotr.Employees.get(i).getPersonName());
            }
        }
        //Поиск менеджеров
        for (int i = 0; i < sotrProject.size(); i++) {
            System.out.println(sotrProject.get(i) + " менеджер проектов " + p1.getListOfManagersForEmployee(sotrProject.get(i)));
        }
        System.out.print("\n");
        //Добавление в лист заказчиков
        ArrayList<String> customerProject = new ArrayList<String>();
        for (int i = 0; i < sotr.Employees.size(); i++) {
            for (int j = 0; j < sotr.Employees.get(i).getProjects().size(); j++) {
                if (!customerProject.contains(sotr.Employees.get(i).getProjects().get(j).getCustomer())) {
                    customerProject.add(sotr.Employees.get(i).getProjects().get(j).getCustomer());
                }
            }
        }
        for (int i = 0; i < customerProject.size(); i++) {
            System.out.println(customerProject.get(i) + " заказчик проектов: " + p1.getListOfProjectsForCustomer(customerProject.get(i)));
        }
    }
}

