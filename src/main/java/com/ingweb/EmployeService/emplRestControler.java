package com.ingweb.EmployeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class emplRestControler {

    private EmployeRepository employeRepository;

    public emplRestControler(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    //http://localhost:8081/employes
    @GetMapping(path = "/employes")
    public List<Employe> getAllEmp() {
        return employeRepository.findAll();
    }
    @GetMapping(value="/employes/{id}")
    public Employe getEmp(@PathVariable(name="id") Long id){
        return employeRepository.findById(id).get();
    }
    @PostMapping(value="/employes")
    public Employe save(@RequestBody Employe emp){
        return employeRepository.save(emp);

    }
    @PutMapping(value="/employes/{id}")
    public Employe updateEmp(@PathVariable(name="id") Long id, @RequestBody Employe emp){
        emp.setId(id);
        return employeRepository.save(emp);
    }
    @DeleteMapping(value="/employes/{id}")
    public void delete(@PathVariable(name="id") Long id){
        employeRepository.deleteById(id);
    }
    //ca marche mais pas par l'utilisation des param
    //@GetMapping(value="/employes/nom/{nom}")
    //public Employe getEmpByName(@PathVariable(name="nom") String nom){
        // Assurez-vous que votre repository a une méthode pour trouver par nom
      //  return employeRepository.findByNom(nom);
    //}
// avec param
    @GetMapping(value="/employes/nom")
    public Employe getEmpByName(@RequestParam(name="nom") String nom){
        // Assurez-vous que votre repository a une méthode pour trouver par nom
        return employeRepository.findByNom(nom);
    }


}