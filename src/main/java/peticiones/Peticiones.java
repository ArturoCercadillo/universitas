package peticiones;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.Alumno;
import beans.Asignatura;
import beans.Profesor;
import beans.Usuario;

public class Peticiones {
	public Usuario httpLogin(String url, String usuario, String password){
	    String source = null;
	    Gson gson = new Gson();
	    Usuario usuarios = null;
	    HttpClient httpClient = HttpClients.createDefault();
	    HttpPost post = new HttpPost(url);

	    List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	    urlParameters.add(new BasicNameValuePair("usuario", usuario));
	    urlParameters.add(new BasicNameValuePair("password", password));

	    try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    try {
	    HttpResponse httpResponse = httpClient.execute(post);
	    source = EntityUtils.toString(httpResponse.getEntity());
	    usuarios = gson.fromJson(source, Usuario.class);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return usuarios;
	}
	public Alumno httpAlumnoById(String url, int id){
	    String source = null;
	    Gson gson = new Gson();
	    Alumno alumno = null;
	    HttpClient httpClient = HttpClients.createDefault();
	    HttpGet get = new HttpGet(url+"/"+id);
	    
	    try {
	    HttpResponse httpResponse = httpClient.execute(get);
	    source = EntityUtils.toString(httpResponse.getEntity());
	    alumno = gson.fromJson(source, Alumno.class);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return alumno;
	}
	public List<Asignatura> httpAsignaturasByAlumno(String url, int id){
	    String source = null;
	    Gson gson = new Gson();
	    List<Asignatura> asignaturas = null;
	    HttpClient httpClient = HttpClients.createDefault();
	    System.out.println(url+"/"+id);
	    HttpGet get = new HttpGet(url+"/"+id);
	    
	    try {
	    HttpResponse httpResponse = httpClient.execute(get);
	    source = EntityUtils.toString(httpResponse.getEntity());
	    Type listType = new TypeToken<List<Asignatura>>() {}.getType();
	    asignaturas = gson.fromJson(source, listType);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return asignaturas;
	}
	public Profesor httpProfesorById(String url, int id){
	    String source = null;
	    Gson gson = new Gson();
	    Profesor profesor = null;
	    HttpClient httpClient = HttpClients.createDefault();
	    HttpGet get = new HttpGet(url+"/"+id);
	    
	    try {
	    HttpResponse httpResponse = httpClient.execute(get);
	    source = EntityUtils.toString(httpResponse.getEntity());
	    profesor = gson.fromJson(source, Profesor.class);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return profesor;
	}
}
