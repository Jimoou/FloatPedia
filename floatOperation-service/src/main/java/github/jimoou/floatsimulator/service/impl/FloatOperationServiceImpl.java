package github.jimoou.floatsimulator.service.impl;

import github.jimoou.floatsimulator.dto.FloatResponse;
import github.jimoou.floatsimulator.model.FloatRequest;
import github.jimoou.floatsimulator.service.FloatOperationService;
import org.springframework.stereotype.Service;

@Service
public class FloatOperationServiceImpl implements FloatOperationService {

  /* 응답 모델 반환 */
  @Override
  public FloatResponse floatResponse(FloatRequest floatRequest) {
    String binaryValue1 = floatToBinary(floatRequest.getValue1());
    String binaryValue2 = floatToBinary(floatRequest.getValue2());

    return FloatResponse.builder()
     .binaryValue1(binaryValue1)
     .binaryToFloatValue1(String.format("%.20f", binaryToFloat(binaryValue1)))
     .binaryValue2(binaryValue2)
     .binaryToFloatValue2(String.format("%.20f", binaryToFloat(binaryValue2)))
     .result(String.format("%.20f", calculateResult(floatRequest)))
     .computationalSpeed(calculateOperationSpeed(floatRequest))
     .usageMemory(calculateMemoryUsage())
     .build();
  }

  /* float을 이진수로 변환 */
  @Override
  public String floatToBinary(float value) {
    return Integer.toBinaryString(Float.floatToIntBits(value));
  }

  /* 이진수를 float으로 변환 */
  @Override
  public float binaryToFloat(String binary) {
    return Float.intBitsToFloat(Integer.parseInt(binary, 2));
  }

  /* 결과 계산(+) */
  @Override
  public float calculateResult(FloatRequest floatRequest) {
    return floatRequest.getValue1() + floatRequest.getValue2();
  }

  /* 연산 속도 계산*/
  @Override
  public long calculateOperationSpeed(FloatRequest floatRequest) {
    long startTime = System.nanoTime();
    calculateResult(floatRequest);
    long endTime = System.nanoTime();
    return endTime - startTime;
  }

  /* 메모리 사용량 */
  @Override
  public long calculateMemoryUsage() {
    Runtime runtime = Runtime.getRuntime();
    runtime.gc(); // 가비지 컬렉션을 실행하여 불필요한 객체 메모리를 해제
    return runtime.totalMemory() - runtime.freeMemory();
  }
}
