//
//  NSMutableArray+Stack.m
//  LC
//
//  Created by ULS on 2/18/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import "NSMutableArray+Stack.h"

@implementation NSMutableArray (Stack)

- (id)push:(id)obj {
    if(obj == nil) {
        return nil;
    }
    [self addObject:obj];
    return obj;
    
}

- (id)pop {
    if([self empty] == YES) {
        return nil;
    }
    id obj = [self objectAtIndex:(self.count - 1)];
    [self removeLastObject];
    return obj;
}

- (id)peek {
    if([self empty] == YES) {
        return nil;
    }
    id obj = [self objectAtIndex:(self.count - 1)];
    return obj;
}

- (BOOL)empty {
    return self.count == 0;
}

@end
