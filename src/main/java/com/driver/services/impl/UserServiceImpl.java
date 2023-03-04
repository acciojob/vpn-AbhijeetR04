package com.driver.services.impl;

import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{
        Country newCountry = new Country();
        CountryName newName = CountryName.valueOf(countryName);
        try{
            newCountry.setCountryName(newName);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        newCountry.setServiceProvider(null);
        User newUser = new User(username, password, newCountry);
        newUser.setMaskedIp(UUID.randomUUID().toString());
        newUser.setOriginalIp(UUID.randomUUID().toString());
        newUser.setConnected(false);
        return newUser;

    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {
        User user = userRepository3.findById(userId).get();
        ServiceProvider serviceProvider = serviceProviderRepository3.findById(serviceProviderId).get();
        user.getServiceProviderList().add(serviceProvider);
        userRepository3.save(user);
        return user;
    }
}
