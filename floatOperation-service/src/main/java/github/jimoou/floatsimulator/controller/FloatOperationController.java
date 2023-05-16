package github.jimoou.floatsimulator.controller;

import github.jimoou.floatsimulator.dto.FloatResponse;
import github.jimoou.floatsimulator.model.FloatRequest;
import github.jimoou.floatsimulator.service.FloatOperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/float-operation")
@AllArgsConstructor
@Tag(name = "float 연산 서비스")
public class FloatOperationController {
  private FloatOperationService floatOperationService;

  @Operation(summary = "결과 응답")
  @PostMapping("/float")
  public ResponseEntity<FloatResponse> floatResponse(@RequestBody FloatRequest floatRequest) {
    FloatResponse floatResponse = floatOperationService.floatResponse(floatRequest);
    return new ResponseEntity<>(floatResponse, HttpStatus.OK);
  }
}
