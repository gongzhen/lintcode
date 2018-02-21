//
//  NSMutableArray+Stack.h
//  LC
//
//  Created by ULS on 2/18/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NSMutableArray (Stack)

- (id)push:(id)obj;
- (id)pop;
- (id)peek;
- (BOOL)empty;

@end
