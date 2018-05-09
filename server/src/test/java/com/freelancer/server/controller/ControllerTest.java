package com.freelancer.server.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ControllerTest {
 
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private ProjectData service;
 
    @Test
    public void getProjectDetails()
      throws Exception {
         
        Project proj = new Project("alex");
     
        List<Project> allProjects = Arrays.asList(proj);
     
        given(service.findAllProjects()).willReturn(allProjects);
     
        mvc.perform(get("/projects/all")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }}