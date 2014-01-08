#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>
#include "mindroid/os/Delegate.h"
#include "mindroid/os/Event.h"

using namespace mindroid;

class Test
{
public:
	void test1(int32_t value) {
		printf("Test::test1 with value %d\n", value);
	}

	void test2(int32_t value) {
		printf("Test::test2 with value %d\n", value);
	}

	Event<void (int32_t)> testIt;
};

int main() {
	Test test;

	Delegate<void (int32_t)> delegate1 = Delegate<void (int32_t)>::create<Test, &Test::test1>(test);
	Delegate<void (int32_t)> delegate2 = Delegate<void (int32_t)>::create<Test, &Test::test2>(test);

	printf("1:\n");
	test.testIt += delegate1;
	test.testIt(1234567);

	printf("2:\n");
	test.testIt -= delegate1;
	test.testIt(1234);

	printf("3:\n");
	test.testIt += delegate1;
	test.testIt(1234);

	printf("4:\n");
	test.testIt += delegate2;
	test.testIt(1234);

	printf("5:\n");
	test.testIt -= delegate1;
	test.testIt(1234);

	printf("6:\n");
	test.testIt -= delegate1;
	test.testIt(1234);

	printf("7:\n");
	test.testIt -= delegate2;
	test.testIt(1234);

	return 0;
}
