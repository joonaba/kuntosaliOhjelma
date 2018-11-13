package palvelinohjelmointi.kuntosaliOhjlema.web;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import palvelinohjelmointi.kuntosaliOhjlema.WebSecurityConfig;
import palvelinohjelmointi.kuntosaliOhjlema.domain.Treeni;
import palvelinohjelmointi.kuntosaliOhjlema.domain.TreeniRepository;
import palvelinohjelmointi.kuntosaliOhjlema.domain.TyyppiRepository;


@Controller
public class TreeniController {
	
@Autowired WebSecurityConfig webSecurityConfig;
	
	@RequestMapping(value= {"/", "/treenilista"})
	public String homeSecure() {
		return "treenilista";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
@Autowired
private TreeniRepository repository;

@Autowired
private TyyppiRepository yrepository;

	@GetMapping(value= "/treenilista")
	public String bookList(Model model) {	
	    model.addAttribute("treenit", repository.findAll());
	    return "treenilista";
	}


	//RESTful service to get all books
	@RequestMapping(value="/treenit", method = RequestMethod.GET)
	public @ResponseBody List<Treeni> treeniListaRest() {	
	    return (List<Treeni>) repository.findAll();
	}    

	// RESTful service to get book by id
	@RequestMapping(value="/treenit/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Treeni> findTreeniRest(@PathVariable("id") Long treeniId) {	
		return repository.findById(treeniId);
	}       

	@RequestMapping(value = "/add")
	public String addBook(Model model){
		model.addAttribute("treeni", new Treeni());
		model.addAttribute("tyypit", yrepository.findAll());
	    return "lisaatreeni";
	}     

	@PostMapping(value = "/save")
	public String save(Treeni treeni){
	    repository.save(treeni);
	    return "redirect:treenilista";
	}    

	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long treeniId, Model model) {
		repository.deleteById(treeniId);
	    return "redirect:../treenilista";
	}     

	@GetMapping(value = "/edit/{id}")
	public String addStudent(@PathVariable("id") Long treeniId, Model model){
		model.addAttribute("treeni", repository.findById(treeniId));
		model.addAttribute("tyypit", yrepository.findAll());
		return "muokkaatreenia";
	}
}
