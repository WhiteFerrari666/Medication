package medicationApp.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import medicationApp.dao.TerminDao;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medicationApp.model.Termin;

@Service
public class KalenderPopulationService {

	@Autowired
	private TerminDao terminDao;

	public void parseAllToJson() throws IOException {

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		List<Termin> termine = terminDao.findAll();
		JSONArray jArray = new JSONArray();
		try {
			for (Termin termin : termine) {
				String bezeichnung = termin.getUhrzeitBezeichnung();
				String datum = termin.getDatum().toString();
				String weblink = termin.getWebLink();

				JSONObject terminJson = new JSONObject();
				terminJson.put("Date", datum);
				terminJson.put("Title", bezeichnung);
				terminJson.put("Link", weblink);
				jArray.put(terminJson);
			}

			StringWriter out = new StringWriter();
			jArray.write(out);
			String jsonText = out.toString();

			HttpPost request = new HttpPost("http://localhost:8080/kalender");
			StringEntity params = new StringEntity(jsonText);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			httpClient.execute(request);
			System.out.println(jsonText);

		} catch (Exception e) {
			System.out.println("Fehler bei der Datenbankübertragung nach JSON");
		}

		finally {
			httpClient.close();
		}
	}
}
