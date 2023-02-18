/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gestion_Echange.services;

import java.util.List;

/**
 *
 * @author amine
 */
public interface IService<T> {
    T Add(T entity);
    void Delete(T entity);
    void Update(T entity);
    List<T> Getall();
    T GetById(int ID);
}
