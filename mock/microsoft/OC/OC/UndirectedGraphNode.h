//
//  UndirectedGraphNode.h
//  LC
//
//  Created by ULS on 2/17/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface UndirectedGraphNode : NSObject

@property (assign)NSInteger label;
@property (strong, nonatomic)NSMutableArray *neighbors;
- (instancetype)initWith:(NSInteger)x;

@end
