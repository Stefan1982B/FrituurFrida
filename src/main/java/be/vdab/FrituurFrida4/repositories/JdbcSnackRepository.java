package be.vdab.FrituurFrida4.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.FrituurFrida4.exceptions.SnackNietGevondenException;
import be.vdab.FrituurFrida4.valueobjects.Snack;

@Repository
public class JdbcSnackRepository implements SnackRepository {

	private final NamedParameterJdbcTemplate template;

	JdbcSnackRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	private final RowMapper<Snack> snackRowMapper = (resultSet, rowNum) -> new Snack(resultSet.getInt("id"),
			resultSet.getString("naam"), resultSet.getBigDecimal("prijs"));

	private static final String READ = "select id, naam, prijs from snacks where id= :id";

	@Override
	public Optional<Snack> read(long id) {
		try {
			return Optional.of(template.queryForObject(READ, Collections.singletonMap("id", id), snackRowMapper));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}

	private static final String UPDATE_SNACK = "update snacks set naam = :naam, prijs = :prijs where id = :id";

	@Override
	public void update(Snack snack) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("naam", snack.getNaam());
		parameters.put("prijs", snack.getPrijs());
		parameters.put("id", snack.getId());
		if (template.update(UPDATE_SNACK, parameters) == 0) {
			throw new SnackNietGevondenException();
		}
	}

	private static final String SELECT_BY_BEGIN_LETTER = "select id, naam, prijs from snacks where naam like :zoals";
	@Override
	public List<Snack> findByBeginNaam(String beginNaam) {
		return template.query(SELECT_BY_BEGIN_LETTER, Collections.singletonMap("zoals", beginNaam + '%'),
				snackRowMapper);
	}


		private static final String SELECT_ALL =   "select id, naam, prijs from snacks order by id"; 
		@Override public List<Snack> findAll() { 
			return template.query(SELECT_ALL, snackRowMapper);  } 
		
	}


