package edu.neu.cs5200.hw5;

import java.util.*;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("site")
public class SiteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("HomeWork5");
	EntityManager em = null;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int siteId) {
		Site site = null;
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		site = em.find(Site.class, siteId);
		
		em.getTransaction().commit();
		em.close();
		
		return site;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites(){
		List<Site> sites = new ArrayList<Site>();
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createNamedQuery("Site.findAll");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		em.close();

		return sites;

	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site){
		List<Site> sites = new ArrayList<Site>();

		em = factory.createEntityManager();
		em.getTransaction().begin();

		site.setId(siteId);
		em.merge(site);
		
		Query query = em.createNamedQuery("Site.findAll");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return sites;

	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int siteId){
		List<Site> sites = new ArrayList<Site>();
		Site site = null;
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		site = em.find(Site.class, siteId);
		em.remove(site);	
		
		Query query = em.createNamedQuery("Site.findAll");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return sites;

	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site){
		List<Site> sites = new ArrayList<Site>();

		em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(site);
		Query query = em.createNamedQuery("Site.findAll");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return sites;

	}

//	public static void main(String args[]){
//		SiteDAO sd = new SiteDAO();
//		Site s;
//		s = sd.findSite(1);
//		for (Site s1 : sd.findAllSites()) {
//			System.out.println(s1.getId() + " " + s1.getName());
//		}
//		for (Site s1 : sd.updateSite(1, new Site(41.1, -70.5, "Site 3"))) {
//			System.out.println(s1.getId() + " " + s1.getName());
//		}
//		for (Site s1 : sd.removeSite(3)){
//			System.out.println(s1.getId() + " " + s1.getName());
//		}
//		for (Site s1 : sd.createSite(new Site(41.1, -70.5, "Site 5"))){
//			System.out.println(s1.getId() + " " + s1.getName());
//		}
//	}

}
