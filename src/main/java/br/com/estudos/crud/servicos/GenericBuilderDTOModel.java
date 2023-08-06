package br.com.estudos.crud.servicos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.estudos.crud.interfaces.IObjectDTO;

public class GenericBuilderDTOModel<T>{
    private Class<T> genericType;

    public GenericBuilderDTOModel(Class<T> type){
        this.genericType = type;
    }

    public T build(IObjectDTO iObjectDTO) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        return build(iObjectDTO, null);
    }

    public T build(IObjectDTO iObjectDTO, Object objectModel) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        if(objectModel == null) objectModel = genericType.getDeclaredConstructor().newInstance();

        for(var methodDTO : iObjectDTO.getClass().getMethods()){
            if(methodDTO.getName().contains("get")){
                String prop = methodDTO.getName().replace("get", "");
                var setMethod = this.getMethod(objectModel, "set" + prop);
                if(setMethod != null){
                    var value = methodDTO.invoke(iObjectDTO);
                    setMethod.invoke(objectModel, value);
                }
            }
        }
        return (T)objectModel;
    }

    public Method getMethod(Object objectModel, String methodName) {
        var methods  = objectModel.getClass().getMethods();
        for(var method : methods){
            if(method.getName().equals(methodName)){
                return method;
            }
        }        
        return null;
    }

}
