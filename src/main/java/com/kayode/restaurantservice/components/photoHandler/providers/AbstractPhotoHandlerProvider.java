package com.kayode.restaurantservice.components.photoHandler.providers;

public abstract class AbstractPhotoHandlerProvider<T> implements PhotoHandlerProvider{

    private Class<T> classProviderSupports;

    public AbstractPhotoHandlerProvider(Class<T> classProviderSupports) {
        this.classProviderSupports=classProviderSupports;
    }

    @Override
    public boolean supports(Class clazz){

        if(clazz.equals(classProviderSupports)){
            return true;
        }

        return false;
    }






}
