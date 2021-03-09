/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor.repositories;

import com.juanros.MessagesInterceptor.model.entities.Communication;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author juan
 */
public interface CommunicationRepository extends MongoRepository<Communication, String> {


}
