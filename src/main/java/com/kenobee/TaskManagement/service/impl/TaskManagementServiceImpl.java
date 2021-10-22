package com.kenobee.TaskManagement.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.kenobee.TaskManagement.firebase.FireBaseInitializer;
import com.kenobee.TaskManagement.dto.TaskDTO;
import com.kenobee.TaskManagement.service.TaskManagementService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author drozohe
 */
@Service
public class TaskManagementServiceImpl implements TaskManagementService {

    //[drozo] Se encarga de inyectar una interface, o un servicio y administrar sus instancias
    //        para manejo de memoria. Se encarga de crear una unica instancia dentro de este servicio.
    @Autowired
    private FireBaseInitializer firebase;

    @Override
    public List<TaskDTO> list() {
        List<TaskDTO> response = new ArrayList<>();
        TaskDTO task;

        //[drozo] Obtener la colección de documentos
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();

        try {
            //[drozo] Por cada documento agregarlo a la lista...
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                task = doc.toObject(TaskDTO.class);//[drozo] Tansformar el documento a tipo Task
                task.setId(doc.getId()); //[drozo] obtener el id
                response.add(task);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(TaskDTO post) {

        //Se crea un mapa para obtener los datos del documento (llave valor)
        Map<String, Object> docData = getDocData(post);

        //[escribir un documento dentro de la colección]    
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

        try {
            //[drozo] Verificar si fue posible escribir el documento
            if (writeResultApiFuture.get() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) { //[drozo] Se prodrian manejar excepciones expecificas. Por ahora una generica...
            return Boolean.FALSE;
        }

    }

    @Override
    public Boolean edit(String id, TaskDTO task) {
        Map<String, Object> docData = getDocData(task);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    //[drozo] Obtener la coleccion de cloudstore
    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("task");
    }

    //[drozo] 
    private Map<String, Object> getDocData(TaskDTO task) {

        Map<String, Object> docData = new HashMap<>();

        //
        docData.put("title", task.getTitle());
        docData.put("content", task.getContent());

        return docData;
    }

}
