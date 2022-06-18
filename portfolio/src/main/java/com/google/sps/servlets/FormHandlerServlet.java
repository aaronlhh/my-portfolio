package com.google.sps.servlets;

// datastore imports
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

// Jsoup imports
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Sanitize user input to remove HTML tags and javascript
        String name = Jsoup.clean(request.getParameter("sender-name"), Whitelist.none());
        String email = Jsoup.clean(request.getParameter("sender-email"), Whitelist.none());
        String message = Jsoup.clean(request.getParameter("message"), Whitelist.none());
        // String name = request.getParameter("sender-name");
        // String email = request.getParameter("sender-email");
        // String message = request.getParameter("message");

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("SenderInfo");

        FullEntity taskEntity =
            Entity.newBuilder(keyFactory.newKey())
                .set("sender-name", name)
                .set("sender-email", email)
                .set("sender-message", message)
                .build();
        datastore.put(taskEntity);

        response.sendRedirect("/index.html");
    }
}