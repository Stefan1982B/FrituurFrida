package be.vdab.FrituurFrida4.repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import be.vdab.FrituurFrida4.exceptions.SausRepositoryException;
import be.vdab.FrituurFrida4.valueobjects.Saus;

@Component
@Qualifier("CSV")
class CSVSausRepository implements SausRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CSVSausRepository.class);
	  private final Path pad;
	  CSVSausRepository(@Value("${CSV}") Path pad) { 
		  this.pad = pad;
		  }

	@Override
	public List<Saus> findAll() {
		List<Saus> sauzen = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(pad)) {
			for (String regel; (regel = reader.readLine()) != null;) {
				if (!regel.isEmpty()) {
					String[] onderdelen = regel.split(",");
					if (onderdelen.length < 2) {
						String fout = "regel bevat minder dan 2 onderdelen";
						LOGGER.error(fout);
						throw new SausRepositoryException(fout);
					}
					try {
						long id = Long.parseLong(onderdelen[0]);
						Saus saus = new Saus(id, onderdelen[1]);
						for (int index = 2; index < onderdelen.length; index++) {
							saus.addIngredient(onderdelen[index]);
						}
						sauzen.add(saus);
					} catch (NumberFormatException ex) {
						String fout = regel + " bevat verkeerde id";
						LOGGER.error(fout, ex);
						throw new SausRepositoryException(fout);
					}
				}
			}
		} catch (IOException ex) {
			String fout = "kan de CSV file niet lezen";
			LOGGER.error(fout, ex);
			throw new SausRepositoryException(fout);

		}
		return sauzen;
	}
}
