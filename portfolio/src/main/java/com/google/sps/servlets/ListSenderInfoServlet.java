package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.Batch.Response;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.data.SenderInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-info")
public class ListSenderInfoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query = 
            Query.newEntityQueryBuilder().setKind("SenderInfo").setOrderBy(OrderBy.asc("timestamp")).build();
        QueryResults<Entity> results = datastore.run(query);

        List<SenderInfo> infos = new ArrayList<>();
        while(results.hasNext()){
            Entity entity = results.next();

            long id = entity.getKey().getId();
            long timestamp = entity.getLong("timestamp");
            String name = entity.getString("sender-name");
            String email = entity.getString("sender-email");
            String message = entity.getString("sender-message");

            SenderInfo info = new SenderInfo(id, timestamp, name, email, message);
            infos.add(info);
        }

        response.setContentType("text/plain");
        for(SenderInfo info : infos ){
            response.getWriter().println(info);
        }

        // Gson gson = new Gson();

        // response.setContentType("application/json;");
        // response.getWriter().println(gson.toJson(infos));

    }
}
