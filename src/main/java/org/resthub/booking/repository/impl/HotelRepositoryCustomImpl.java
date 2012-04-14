package org.resthub.booking.repository.impl;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.resthub.booking.model.Hotel;
import org.resthub.booking.repository.HotelRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * @author Guillaume Zurbach
 */
@Named("hotelRepositoryImpl")
public class HotelRepositoryCustomImpl implements HotelRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Page<Hotel> find(final String input, final Pageable pageable) {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
            QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Hotel.class ).get();
            org.apache.lucene.search.Query query = null;
            if((input == null) || (input.isEmpty())) {
                query = qb.all().createQuery();
            } else {
                query = qb.keyword().onFields("name", "address", "city", "state", "country").matching(input).createQuery();
            }
            
            // wrap Lucene query in a javax.persistence.Query
            javax.persistence.Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Hotel.class);

            if (pageable == null) {
                    return new PageImpl<Hotel>(persistenceQuery.getResultList());
            } else {
                    persistenceQuery.setFirstResult(pageable.getOffset());
                    persistenceQuery.setMaxResults(pageable.getPageSize());
                    return new PageImpl<Hotel>(persistenceQuery.getResultList(), pageable, persistenceQuery.getResultList().size());
            }
	}

}
