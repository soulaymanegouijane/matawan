package com.matawan.test.controllers;

import com.matawan.test.repositories.TeamRepository;
import com.matawan.test.services.TeamService;
import com.matawan.test.utils.mappers.TeamDtoToEntityMapper;
import com.matawan.test.utils.mappers.TeamEntityToDtoMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
@ExtendWith(MockitoExtension.class)
class TeamControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TeamService teamService;

    @MockBean
    TeamDtoToEntityMapper teamDtoToEntityMapper;

    @MockBean
    TeamEntityToDtoMapper teamEntityToDtoMapper;

    @MockBean
    TeamRepository teamRepository;

    String jsonString = """
            {
                 "teamName":"Borkina FASSOD",
                 "teamAcronym":"BFS",
                 "teamBudget": 1558522,
                 "players":[
                     {
                         "playerName":"BOMBA",
                         "playerPosition":"Middelfield"
                     }
                 ]
             }
            """;

    @Test
//    @Disabled
    void shouldAddTeam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)).andExpect(status().isOk());
        verify(teamDtoToEntityMapper).apply(any());
        verify(teamService).addTeam(any());
    }

    @Test
    @Disabled
    void getTeamsSortedAndByPage() {

    }
}