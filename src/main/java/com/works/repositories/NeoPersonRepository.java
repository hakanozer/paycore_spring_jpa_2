package com.works.repositories;

import com.works.nodes.Noe4jEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NeoPersonRepository extends Neo4jRepository<Noe4jEntity, String> {

}
