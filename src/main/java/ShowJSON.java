import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.*;
@WebServlet("/json")
public class ShowJSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Gson gson=new Gson();
        Form form=new Form(req.getParameter("name"),Integer.parseInt(req.getParameter("age")),req.getParameter("bio"));
        resp.getWriter().println(gson.toJson(form));
    }
    class Form{
        String name;
        Integer age;
        String bio;

        public Form(String name, Integer age, String bio) {
            this.name = name;
            this.age = age;
            this.bio = bio;
        }
    }
}
